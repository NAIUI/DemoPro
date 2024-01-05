/*
Copyright (C) THL A29 Limited, a Tencent company. All rights reserved.

SPDX-License-Identifier: Apache-2.0
*/

package org.chainmaker.sdk.utils;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import com.sansec.jce.provider.SwxaProvider;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.zayk.mmk.ECCSignature;
import com.zayk.mmk.ECCrefPublicKey;
import com.zayk.mmk.StructTransform;
import com.zayk.mmk.ZAYKSDFLibrary;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;
import org.chainmaker.pb.accesscontrol.MemberOuterClass;
import org.chainmaker.pb.accesscontrol.MemberOuterClass.MemberType;
import org.chainmaker.pb.common.Request;
import org.chainmaker.sdk.User;
import org.chainmaker.sdk.config.AuthType;
import org.chainmaker.sdk.crypto.ChainMakerCryptoSuiteException;

public class SdkUtils {

    private static final int RS_LEN = 32;
    private static final int HSM_MAX_LEN = 8192;

    public static Request.EndorsementEntry[] getEndorsers(Request.Payload payload, User[] users)
            throws ChainMakerCryptoSuiteException, UtilsException {

        Request.EndorsementEntry[] endorsementEntries = new Request.EndorsementEntry[users.length];

        for (int i = 0; i < users.length; i++) {
            Request.EndorsementEntry entry = signPayload(users[i], payload.toByteArray());
            endorsementEntries[i] = entry;
        }
        return endorsementEntries;
    }

    private static Request.EndorsementEntry signPayload(User user, byte[] payload)
            throws ChainMakerCryptoSuiteException, UtilsException {
        if (user.getAuthType().equals(AuthType.PermissionedWithCert.getMsg())) {
            byte[] signature = null;
            if (("").equals(user.getKeyId()) || user.getKeyId() == null){
                signature = user.getCryptoSuite().sign(user.getPrivateKey(), payload);
            } else {
                signature = user.getCryptoSuite().signWithHsm(Integer.parseInt(user.getKeyId()), user.getKeyType(), payload);
            }
            return Request.EndorsementEntry.newBuilder().setSignature(
                    ByteString.copyFrom(signature))
                    .setSigner(getSerializedMember(user)).build();
        } else {
            return Request.EndorsementEntry.newBuilder().setSignature(
                    ByteString.copyFrom(user.getCryptoSuite().rsaSign(CryptoUtils.getPrivateKeyFromBytes(user.getPriBytes()), payload)))
                    .setSigner(getSerializedMember(user.getOrgId(), user.getPriBytes())).build();
        }
    }

    // Get the SerializedMember according whether enabled cert hash
    public static MemberOuterClass.Member getSerializedMember(User user) {
        return MemberOuterClass.Member.newBuilder()
                .setOrgId(user.getOrgId())
                .setMemberInfo(ByteString.copyFrom(user.getCertBytes()))
                .setMemberType(MemberOuterClass.MemberType.CERT)
                .build();
    }

    public static MemberOuterClass.Member getSerializedMember(String orgId, byte[] pkBytes) throws UtilsException {
        return MemberOuterClass.Member.newBuilder()
                .setOrgId(orgId)
                .setMemberInfo(ByteString.copyFrom(dealRsaPk(pkBytes)))
                .setMemberType(MemberOuterClass.MemberType.PUBLIC_KEY)
                .build();
    }

    public static byte[] dealRsaPk(byte[] pemKey) throws UtilsException {
//        KeyFactory kf;
        PrivateKey priv;
        PublicKey publicKey;
        try {
            priv = CryptoUtils.getPrivateKeyFromBytes(pemKey);
            publicKey = CryptoUtils.getPublicKeyFromPrivateKey(priv);
//            kf = KeyFactory.getInstance("RSA");
//            priv = kf.getKeySpec(CryptoUtils.getPrivateKeyFromBytes(pemKey), RSAPrivateKeySpec.class);
//            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(priv.getModulus(), BigInteger.valueOf(65537));
//            publicKey = kf.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | ChainMakerCryptoSuiteException e) {
            throw new UtilsException("new RSAPublicKeySpec err: " + e.getMessage());
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }

        StringWriter writer = new StringWriter();
        PemWriter pemWriter = new PemWriter(writer);
        try {
            pemWriter.writeObject(new PemObject("PUBLIC KEY", publicKey.getEncoded()));
            pemWriter.flush();
            pemWriter.close();
        } catch (IOException e) {
            throw new UtilsException("publicKey parse to pem err :" + e.getMessage());
        }

        return writer.toString().getBytes();
    }

    public static byte[] signWithHSM(int keyId, byte[] plainText) throws ChainMakerCryptoSuiteException {
        PointerByReference ppHandle = new PointerByReference(Pointer.NULL);

        PointerByReference ppSessionHandle = new PointerByReference(Pointer.NULL);
        Pointer pHandle = null;
        Pointer pSessionHandle = null;
        ECCSignature pucSignature = new ECCSignature();
        try {
            int rv = ZAYKSDFLibrary.SDF_OpenDevice(ppHandle);
            if(rv != 0)
            {
                throw new ChainMakerCryptoSuiteException("SDF_OpenDevice failed :" + rv);
            }

            pHandle = ppHandle.getValue();

            rv = ZAYKSDFLibrary.SDF_OpenSession(pHandle, ppSessionHandle);
            if(rv != 0)
            {
                throw new ChainMakerCryptoSuiteException("SDF_OpenSession failed :" + rv);
            }
            pSessionHandle= ppSessionHandle.getValue();

            ECCrefPublicKey pucPublicKey=new ECCrefPublicKey();
            rv = ZAYKSDFLibrary.SDF_ExportSignPublicKey_ECC(pSessionHandle, keyId, pucPublicKey);
            if(rv != 0)
            {
                throw new ChainMakerCryptoSuiteException("SDF_ExportSignPublicKey_ECC failed :" + rv);
            }

            rv = ZAYKSDFLibrary.SDF_HashInit(pSessionHandle, ZAYKSDFLibrary.SGD_SM3, pucPublicKey, "1234567812345678".getBytes(), 16);
            if(rv != 0)
            {
                throw new ChainMakerCryptoSuiteException("SDF_HashInit failed :" + rv);
            }

            byte[] plainText8k = null;

            if (plainText.length <= HSM_MAX_LEN) {
                rv = ZAYKSDFLibrary.SDF_HashUpdate(pSessionHandle, plainText, plainText.length);
                if(rv != 0)
                {
                    throw new ChainMakerCryptoSuiteException("SDF_HashUpdate failed :" + rv);
                }
            } else {
                for (int i = 0; i < (plainText.length / HSM_MAX_LEN) + 1; i++) {
                    if (i == (plainText.length / HSM_MAX_LEN)){
                        //最后一个
                        plainText8k = Arrays.copyOfRange(plainText, i * HSM_MAX_LEN, plainText.length);
                        rv = ZAYKSDFLibrary.SDF_HashUpdate(pSessionHandle, plainText8k, plainText8k.length);
                        if(rv != 0)
                        {
                            throw new ChainMakerCryptoSuiteException("SDF_HashUpdate failed :" + rv);
                        }
                    } else {
                        plainText8k = Arrays.copyOfRange(plainText, i * HSM_MAX_LEN, (i + 1) * HSM_MAX_LEN);
                        rv = ZAYKSDFLibrary.SDF_HashUpdate(pSessionHandle, plainText8k, plainText8k.length);
                        if(rv != 0)
                        {
                            throw new ChainMakerCryptoSuiteException("SDF_HashUpdate failed :" + rv);
                        }
                    }
                }
            }

            byte[] outData=new byte[32];
            IntByReference outDataLength = new IntByReference();

            rv = ZAYKSDFLibrary.SDF_HashFinal(pSessionHandle, outData, outDataLength);
            if(rv != 0)
            {
                throw new ChainMakerCryptoSuiteException("SDF_HashFinal failed :" + rv);
            }

            rv = ZAYKSDFLibrary.SDF_InternalSign_ECC(pSessionHandle, keyId, outData, outData.length, pucSignature);
            if(rv != 0)
            {
                throw new ChainMakerCryptoSuiteException("SDF_InternalSign_ECC failed :" + rv);
            }
        } catch (ChainMakerCryptoSuiteException e) {
            throw new ChainMakerCryptoSuiteException("signWithHSM failed : " + e.getMessage());
        } finally {
            int rv = ZAYKSDFLibrary.SDF_CloseSession(pSessionHandle);
            if(rv!=0)
            {
                System.out.println("---------->SDF_CloseSession rv="+rv);
            }
            rv = ZAYKSDFLibrary.SDF_CloseDevice(pHandle);
            if(rv!=0)
            {
                System.out.println("---------->SDF_CloseDevice rv="+rv);
            }
        }

        return rsPlainByteArrayToAsn1(StructTransform.ZAYK_SignStructToByte(pucSignature));
    }

    public static byte[] rsPlainByteArrayToAsn1(byte[] sign) {
        if (sign.length != RS_LEN * 2) {
            throw new RuntimeException("err rs. ");
        }
        BigInteger r = new BigInteger(1, Arrays.copyOfRange(sign, 0, RS_LEN));
        BigInteger s = new BigInteger(1, Arrays.copyOfRange(sign, RS_LEN, RS_LEN * 2));
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(new ASN1Integer(r));
        v.add(new ASN1Integer(s));
        try {
            return new DERSequence(v).getEncoded("DER");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

