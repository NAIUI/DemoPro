package org.chainmaker.sdk;

import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;
import org.bouncycastle.math.ec.ECPoint;
import org.chainmaker.pb.common.ContractOuterClass;
import org.chainmaker.pb.syscontract.ContractManage;
import org.chainmaker.sdk.crypto.ChainMakerCryptoSuiteException;
import org.chainmaker.sdk.utils.CryptoUtils;
import org.chainmaker.sdk.utils.FileUtils;
import org.chainmaker.sdk.utils.UtilsException;
import org.junit.Test;
import org.bouncycastle.jce.interfaces.ECPrivateKey;


import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class TestCroptoUtils extends TestBase{

    @Test
    public void testGetPublicKeyFromPrivateKey() throws Exception {
        String privateKeyFilePath;
        privateKeyFilePath = "keys/ec.key";
        privateKeyFilePath = "keys/rsa.key";
        privateKeyFilePath = "keys/gm.key";

        byte[] pemKey = FileUtils.getFileBytes(privateKeyFilePath);
        PrivateKey privateKey = CryptoUtils.getPrivateKeyFromBytes(pemKey);
        PublicKey publicKey = CryptoUtils.getPublicKeyFromPrivateKey(privateKey);
        System.out.println(publicKey);
    }

}
