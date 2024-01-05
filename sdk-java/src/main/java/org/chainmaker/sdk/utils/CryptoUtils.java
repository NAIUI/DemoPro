/*
Copyright (C) THL A29 Limited, a Tencent company. All rights reserved.

SPDX-License-Identifier: Apache-2.0
*/

package org.chainmaker.sdk.utils;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;


import org.bouncycastle.asn1.*;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.RSAPublicKey;
import org.bouncycastle.asn1.x509.*;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.bouncycastle.jcajce.provider.digest.Keccak;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.util.encoders.Hex;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;
import org.bouncycastle.util.io.pem.PemWriter;
import org.chainmaker.pb.config.ChainConfigOuterClass;
import org.chainmaker.sdk.crypto.ChainMakerCryptoSuiteException;

import java.security.cert.*;
import java.security.cert.Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.spec.*;
import java.util.Objects;

import org.web3j.crypto.Hash;

public class CryptoUtils {

    private static final int ZX_ADDR_SUFFIX_LENGTH = 20;
    private static final String ZX_ADDR_PREFIX = "ZX";
    private static final String RSA_PRE = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8A";
    private static final String HEX_ADDR_PREFIX = "0x";

    private static final String SECP256R1 = "secp256r1";
    private static final String SECP = "secp";



    private CryptoUtils() {
        throw new IllegalStateException("Crypto Utils class");
    }

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static PrivateKey getPrivateKeyFromBytes(byte[] pemKey) throws ChainMakerCryptoSuiteException {
        PrivateKey pk = null;

        try {
            PemReader pr = new PemReader(new StringReader(new String(pemKey)));
            PemObject po = pr.readPemObject();
            PEMParser pem = new PEMParser(new StringReader(new String(pemKey)));

            if (po.getType().equals("PRIVATE KEY")) {
                pk = new JcaPEMKeyConverter().getPrivateKey((PrivateKeyInfo) pem.readObject());
            } else if (po.getType().equals("EC PRIVATE KEY")) {
                ASN1Sequence sequence = ASN1Sequence.getInstance(po.getContent());
                org.bouncycastle.asn1.sec.ECPrivateKey ecPrivateKey = org.bouncycastle.asn1.sec.ECPrivateKey.getInstance(sequence);
                Security.addProvider(new BouncyCastleProvider());
                ECParameterSpec spec = ECNamedCurveTable.getParameterSpec(SECP256R1);;
                org.bouncycastle.jce.spec.ECPrivateKeySpec ecPrivateKeySpec = new org.bouncycastle.jce.spec.ECPrivateKeySpec(ecPrivateKey.getKey(), spec);
                KeyFactory factory = KeyFactory.getInstance("ECDSA", new BouncyCastleProvider());
                return factory.generatePrivate(ecPrivateKeySpec);

            } else {
                PEMKeyPair kp = (PEMKeyPair) pem.readObject();
                pk = new JcaPEMKeyConverter().getPrivateKey(kp.getPrivateKeyInfo());
            }
        } catch (Exception e) {
            throw new ChainMakerCryptoSuiteException(e.toString());
        }
        return pk;
    }

    public static PublicKey getPublicKeyFromPrivateKey(PrivateKey privateKey) throws ChainMakerCryptoSuiteException,
            NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException {
        PublicKey publicKey;
        String algo = privateKey.getAlgorithm();
        if ("RSA".equals(algo)) {
            KeyFactory kf = KeyFactory.getInstance("RSA");
            RSAPrivateKeySpec rsaPrivateKeySpec = kf.getKeySpec(privateKey, RSAPrivateKeySpec.class);
            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(rsaPrivateKeySpec.getModulus(), BigInteger.valueOf(65537));
            publicKey = kf.generatePublic(keySpec);
        } else if ("ECDSA".equals(algo) || "EC".equals(algo)) { // 支持EC 国密 ？
            KeyFactory keyFactory = KeyFactory.getInstance("ECDSA", "BC");

            ECPrivateKey ecPrivateKey = (ECPrivateKey) privateKey;
            ECParameterSpec ecSpec = ecPrivateKey.getParameters();
            ECPoint Q = ecSpec.getG().multiply(ecPrivateKey.getD());
            ECPublicKeySpec pubSpec = new ECPublicKeySpec(Q, ecSpec);
            publicKey = keyFactory.generatePublic(pubSpec);
        } else {
            throw new ChainMakerCryptoSuiteException("Not support private key for algorithm: " + algo);
        }
        return publicKey;
    }

    public static String makeAddrFromPubKeyPem(PublicKey publicKey) throws IOException {
        byte[] encoded = publicKey.getEncoded();
        SubjectPublicKeyInfo subjectPublicKeyInfo = new SubjectPublicKeyInfo(
                ASN1Sequence.getInstance(encoded));
        byte[] subjectPublicKeyEncoded = subjectPublicKeyInfo.parsePublicKey().getEncoded();
        Digest digest = new SHA256Digest();
        byte[] retValue = new byte[digest.getDigestSize()];
        digest.update(subjectPublicKeyEncoded, 0, subjectPublicKeyEncoded.length);
        digest.doFinal(retValue, 0);

        String ski = Hex.toHexString(retValue);

        byte[] data = Hex.decode(ski);
        Keccak.DigestKeccak kecc = new Keccak.Digest256();
        kecc.update(data, 0, data.length);
        byte[] address = kecc.digest();
        String addr = Hex.toHexString(address);
        return HEX_ADDR_PREFIX + addr.substring(24);
    }

    public static String makeAddrFromCert(Certificate certificate) throws UtilsException {

        ByteArrayInputStream bIn = null;
        try {
            bIn = new ByteArrayInputStream(certificate.getEncoded());
        } catch (CertificateEncodingException e) {
            throw new UtilsException("certificate to ByteArrayInputStream err : " + e.getMessage());
        }
        ASN1InputStream aIn = new ASN1InputStream(bIn);

        ASN1Sequence seq = null;
        try {
            seq = (ASN1Sequence) aIn.readObject();
        } catch (IOException e) {
            throw new UtilsException("certificate to ASN1Sequence err : " + e.getMessage());
        }

        org.bouncycastle.asn1.x509.Certificate obj = org.bouncycastle.asn1.x509.Certificate.getInstance(seq);
        TBSCertificate tbsCertificate = obj.getTBSCertificate();
        Extensions ext = tbsCertificate.getExtensions();

        SubjectKeyIdentifier si = SubjectKeyIdentifier.fromExtensions(ext);
        String ski = Hex.toHexString(si.getKeyIdentifier());

        byte[] data = Hex.decode(ski);
        Keccak.DigestKeccak kecc = new Keccak.Digest256();
        kecc.update(data, 0, data.length);
        byte[] address = kecc.digest();
        String addr = Hex.toHexString(address);
        return HEX_ADDR_PREFIX + addr.substring(24);
    }

    public static String getPemStrFromPublicKey(PublicKey publicKey) throws UtilsException {
        StringWriter writer = new StringWriter();
        PemWriter pemWriter = new PemWriter(writer);
        try {
            pemWriter.writeObject(new PemObject("PUBLIC KEY", publicKey.getEncoded()));
            pemWriter.flush();
            pemWriter.close();
        } catch (IOException e) {
            throw new UtilsException("publicKey parse to pem err :" + e.getMessage());
        }

        return writer.toString();
    }

    public static String getZXAddressFromPKPEM(String pk) throws UtilsException {
        pk = pk.replace(RSA_PRE, "");
        PemReader pr = new PemReader(new StringReader(new String(pk)));
        PemObject po = null;
        byte[] plainText = null;
        try {
            po = pr.readPemObject();
            RSAPublicKey rsaPublicKey = RSAPublicKey.getInstance(po.getContent());
            plainText = rsaPublicKey.toASN1Primitive().getEncoded();
        } catch (IOException e) {
            throw new UtilsException("publicKey parse to addr err :" + e.getMessage());
        }
        Digest digest = new SM3Digest();
        byte[] retValue = new byte[digest.getDigestSize()];
        digest.update(plainText, 0, plainText.length);
        digest.doFinal(retValue, 0);
        byte[] addrBytes = new byte[ZX_ADDR_SUFFIX_LENGTH];
        System.arraycopy(retValue, 0, addrBytes, 0, ZX_ADDR_SUFFIX_LENGTH);
        return ZX_ADDR_PREFIX + Hex.toHexString(addrBytes);
    }

    /**
     * 根据证书获取EVM地址
     * @param certBytes 证书byte数组
     * @return 地址
     */
    public static String getEVMAddressFromCertBytes(byte[] certBytes) {
        Certificate certificate = parseCertificate(certBytes);
        try {
            return certToAddrStr(certificate, ChainConfigOuterClass.AddrType.ETHEREUM);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据私钥获取EVM地址
     * @param privateKey 私钥
     * @param hashType 私钥hash类型
     * @return 地址
     */
    public static String getEVMAddressFromPrivateKeyBytes(byte[] privateKey, String hashType) {
        PublicKey publicKey = null;
        try {
            publicKey = getPublicKeyFromPrivateKey(getPrivateKeyFromBytes(privateKey));
        } catch (ChainMakerCryptoSuiteException | NoSuchAlgorithmException | InvalidKeySpecException |
                 NoSuchProviderException e) {
            throw new RuntimeException(e);
        }

        return pkToAddrStr(publicKey, ChainConfigOuterClass.AddrType.ETHEREUM, hashType);
    }

    /**
     * 根据pkHex获取地址
     * @param pkHex
     * @param hashType 公钥hash类型
     * @param algo 公钥算法 EC/RSA
     * @return 地址
     */
    public static String getEVMAddressFromPKHex(String pkHex, String hashType, String algo) {
        PublicKey publicKey = hexToPublicKey(pkHex, algo);
        return pkToAddrStr(publicKey, ChainConfigOuterClass.AddrType.ETHEREUM, hashType);
    }

    /**
     * 根据公钥获取地址
     * @param pkPem 公钥
     * @param hashType 公钥hash类型
     * @param algo 公钥算法 EC/RSA
     * @return 地址
     */
    public static String getEVMAddressFromPKPEM(String pkPem, String hashType, String algo) {
        PublicKey publicKey = publicKeyFromPem(pkPem, algo);
        return pkToAddrStr(publicKey, ChainConfigOuterClass.AddrType.ETHEREUM, hashType);
    }

    /**
     * 根据pkHex获取ZXL地址
     * @param pkHex
     * @param hashType 公钥hash类型
     * @param algo 公钥算法 EC/RSA
     * @return 地址
     */
    public static String getZXAddressFromPKHex(String pkHex, String hashType, String algo) {
        PublicKey publicKey = hexToPublicKey(pkHex, algo);
        return ZX_ADDR_PREFIX + pkToAddrStr(publicKey, ChainConfigOuterClass.AddrType.ZXL, hashType);
    }


    /**
     * 根据公钥获取ZXL地址
     * @param pkPem 公钥
     * @param hashType 公钥hash类型
     * @param algo 公钥算法 EC/RSA
     * @return 地址
     */
    public static String getZXAddressFromPKPEM(String pkPem, String hashType, String algo) {
        PublicKey publicKey = publicKeyFromPem(pkPem, algo);
        return ZX_ADDR_PREFIX + pkToAddrStr(publicKey, ChainConfigOuterClass.AddrType.ZXL, hashType);
    }

    /**
     * 根据证书获取ZXL地址
     * @param certPem 证书
     * @return 地址
     */
    public static String getZXAddressFromCertPEM(String certPem) {
        Certificate certificate = parseCertificate(certPem.getBytes(StandardCharsets.UTF_8));
        String addr;
        try {
            addr = certToAddrStr(certificate, ChainConfigOuterClass.AddrType.ZXL);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        return ZX_ADDR_PREFIX + addr;
    }


    /**
     * 根据pkHex获取Chainmaker地址
     * @param pkHex
     * @param hashType 公钥hash类型
     * @param algo 公钥算法 EC/RSA
     * @return 地址
     */
    public static String getCMAddressFromPKHex(String pkHex, String hashType, String algo) {
        PublicKey publicKey = hexToPublicKey(pkHex, algo);
        return pkToAddrStr(publicKey, ChainConfigOuterClass.AddrType.CHAINMAKER, hashType);
    }

    /**
     * 根据pk获取Chainmaker地址
     * @param pkPem 公钥
     * @param hashType 公钥hash类型
     * @param algo 公钥算法 EC/RSA
     * @return 地址
     */
    public static String getCMAddressFromPKPEM(String pkPem, String hashType, String algo) {
        PublicKey publicKey = publicKeyFromPem(pkPem, algo);
        return pkToAddrStr(publicKey, ChainConfigOuterClass.AddrType.CHAINMAKER, hashType);
    }

    /**
     * 根据证书获取Chainmaker地址
     * @param certPem 证书
     * @return 地址
     */
    public static String getCMAddressFromCertPEM(String certPem) {
        Certificate certificate = parseCertificate(certPem.getBytes());
        String addr = null;
        try {
            return certToAddrStr(certificate, ChainConfigOuterClass.AddrType.CHAINMAKER);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }


    private static String generteAddrStr(byte[] data, ChainConfigOuterClass.AddrType addrType) {
        if (addrType == ChainConfigOuterClass.AddrType.ZXL) {
            String zxAddress = zxAddress(data);
            return zxAddress.substring(2);
        } else {
            byte[] bytesAddr = keccak256(data);
            return Hex.toHexString(bytesAddr).substring(24);
        }
    }

    public static String nameToAddrStr(String data, ChainConfigOuterClass.AddrType addrType) {
        return generteAddrStr(data.getBytes(StandardCharsets.UTF_8), addrType);
    }

    public static String pkToAddrStr(PublicKey publicKey, ChainConfigOuterClass.AddrType addrType, String hashType) {
        if (addrType == ChainConfigOuterClass.AddrType.CHAINMAKER) {
            byte[] encoded = publicKey.getEncoded();
            SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(
                    ASN1Sequence.getInstance(encoded));
            byte[] subjectPublicKeyEncoded = subjectPublicKeyInfo.getPublicKeyData().getBytes();
            byte[] data = Hash.hash(subjectPublicKeyEncoded, hashType);
            return generteAddrStr(data, addrType);
        }

        byte[] result = marshalPublicKey(publicKey);
        if (addrType == ChainConfigOuterClass.AddrType.ETHEREUM) {
            byte[] dest = new byte[result.length - 1];
            System.arraycopy(result, 1, dest, 0, result.length - 1);
            return generteAddrStr(dest, addrType);
        }
        return generteAddrStr(result, addrType);
    }

    public static String certToAddrStr(Certificate certificate, ChainConfigOuterClass.AddrType addrType) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (addrType == ChainConfigOuterClass.AddrType.CHAINMAKER) {
            ByteArrayInputStream bIn = null;
            try {
                bIn = new ByteArrayInputStream(certificate.getEncoded());
            } catch (CertificateEncodingException e) {
            }
            ASN1InputStream aIn = new ASN1InputStream(bIn);

            ASN1Sequence seq = null;
            try {
                seq = (ASN1Sequence) aIn.readObject();
            } catch (IOException e) {
            }

            org.bouncycastle.asn1.x509.Certificate obj = org.bouncycastle.asn1.x509.Certificate.getInstance(seq);

            TBSCertificate tbsCertificate = obj.getTBSCertificate();
            Extensions ext = tbsCertificate.getExtensions();

            SubjectKeyIdentifier si = SubjectKeyIdentifier.fromExtensions(ext);
            return generteAddrStr(si.getKeyIdentifier(), addrType);
        }

        PublicKey publicKey = certificate.getPublicKey();

        byte[] result = marshalPublicKey(publicKey);
        if (addrType == ChainConfigOuterClass.AddrType.ETHEREUM) {
            byte[] dest = new byte[result.length - 1];
            System.arraycopy(result, 1, dest, 0, result.length - 1);
            return generteAddrStr(dest, addrType);
        }
        return generteAddrStr(result, addrType);
    }


    private static String zxAddress(byte[] data) {
        SM3Digest digest = new SM3Digest();
        digest.update(data, 0, data.length);
        byte[] result = new byte[digest.getDigestSize()];
        digest.doFinal(result, 0);
        if (result.length < ZX_ADDR_SUFFIX_LENGTH) {
            return "";
        }
        byte[] dest = new byte[ZX_ADDR_SUFFIX_LENGTH];
        System.arraycopy(result, 0, dest, 0, ZX_ADDR_SUFFIX_LENGTH);
        return ZX_ADDR_PREFIX + Hex.toHexString(dest);
    }

    private static byte[] keccak256(byte[] data) {
        Keccak.Digest256 keccakDigest = new Keccak.Digest256();
        return keccakDigest.digest(data);
    }

    private static PublicKey publicKeyFromPem(String pkPem, String algo) {
        KeyFactory factory = null;
        try {
            factory = KeyFactory.getInstance(algo);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }


        PemReader pemReader = new PemReader(new StringReader(pkPem));
        PemObject pemObject = null;
        try {
            pemObject = pemReader.readPemObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        byte[] content = pemObject.getContent();
        X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(content);
        try {
            return factory.generatePublic(pubKeySpec);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }

    }

    private static PublicKey hexToPublicKey(String publicKeyHexStr, String algo) {
        KeyFactory keyFact = null;
        try {
            keyFact = KeyFactory.getInstance(algo);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(new BigInteger(publicKeyHexStr, 16).toByteArray());
        try {
            return keyFact.generatePublic(x509KeySpec);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    private static Certificate parseCertificate(byte[] cert) {
        X509Certificate ret = null;
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            ByteArrayInputStream certInputStream = new ByteArrayInputStream(cert);
            ret = (X509Certificate) cf.generateCertificate(certInputStream);
        } catch (CertificateException e) {
            throw new RuntimeException(e);
        }
        return ret;
    }

    /**
     * 根据公钥获取获取ans1模式的byte数组
     * @param publicKey 公钥
     * @return ans1的byte数组
     */
    private static byte[] marshalPublicKey(PublicKey publicKey) {
        if (Objects.equals(publicKey.getAlgorithm(), "ECDSA") || Objects.equals(publicKey.getAlgorithm(), "EC")) {
            if (publicKey instanceof BCECPublicKey) {
                BCECPublicKey pubKey = (BCECPublicKey) publicKey;
                ECParameterSpec spec = pubKey.getParameters();
                return publicKeyToByte(pubKey, ((ECNamedCurveParameterSpec)spec).getName());
            } else {
                BCECPublicKey pubKey = new BCECPublicKey((ECPublicKey) publicKey, BouncyCastleProvider.CONFIGURATION);
                return publicKeyToByte(pubKey, pubKey.getParams().toString());
            }
        } else if (Objects.equals(publicKey.getAlgorithm(), "RSA")) {
            try {
                return ((RSAPublicKey) publicKey).toASN1Primitive().getEncoded();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return new byte[0];
    }

    private static byte[] publicKeyToByte(BCECPublicKey publicKey, String name) {
        // name is secp521r1 or secp256r1
        if (name.contains(SECP)) {
            return ecPublickeyToByte(publicKey);
        // name is sm2p256v1
        } else {
            return sm2PublickeyToByte(publicKey);
        }
    }


    /**
     * sm2计算ans1
     * @param publicKey 公钥
     * @return byte数组
     */
    private static byte[] sm2PublickeyToByte(BCECPublicKey publicKey) {
        int length =  (publicKey.getParams().getCurve().getField().getFieldSize() + 7 ) / 8;
        BigInteger x =  publicKey.getQ().getXCoord().toBigInteger();
        BigInteger y = publicKey.getQ().getYCoord().toBigInteger();
        byte[] a = x.abs().toByteArray();
        byte[] b = y.abs().toByteArray();
        byte[] result = new byte[1 + 2 * length];
        result[0] = 4;
        System.arraycopy(a, 0, result,1, length);
        System.arraycopy(b, 0, result,length + 1, length);
        return result;
    }

    /**
     * ec计算ans1
     * @param publicKey 公钥
     * @return byte数组
     */
    private static byte[] ecPublickeyToByte(BCECPublicKey publicKey) {
        int length =  (publicKey.getParams().getCurve().getField().getFieldSize() + 7 ) / 8;
        byte[] x = publicKey.getQ().getXCoord().getEncoded();
        byte[] y = publicKey.getQ().getYCoord().getEncoded();
        byte[] result = new byte[1 + 2 * length];
        result[0] = 4;
        System.arraycopy(x, 0, result,1, length);
        System.arraycopy(y, 0, result,length + 1, length);
        return result;
    }

}
