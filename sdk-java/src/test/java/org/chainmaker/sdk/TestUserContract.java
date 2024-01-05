/*
Copyright (C) THL A29 Limited, a Tencent company. All rights reserved.

SPDX-License-Identifier: Apache-2.0
*/

package org.chainmaker.sdk;

import org.chainmaker.pb.common.ContractOuterClass;
import org.chainmaker.pb.common.Request;
import org.chainmaker.pb.common.ResultOuterClass;
import org.chainmaker.sdk.config.AuthType;
import org.chainmaker.sdk.crypto.ChainMakerCryptoSuiteException;
import org.chainmaker.sdk.utils.FileUtils;
import org.chainmaker.sdk.utils.SdkUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestUserContract extends TestBase {
    private static final String QUERY_CONTRACT_METHOD = "query";
    private static final String INVOKE_CONTRACT_METHOD = "increase";
    private static final String CONTRACT_NAME = "counter";
    private static final String CONTRACT_FILE_PATH = "rust-fact-1.0.0.wasm";

    @Test
    public void testCreateContract() {
        ResultOuterClass.TxResponse responseInfo = null;
        try {
            byte[] byteCode = FileUtils.getResourceFileBytes(CONTRACT_FILE_PATH);

            // 1. create payload
            Request.Payload payload = chainClient.createContractCreatePayload(CONTRACT_NAME, "1", byteCode,
                    ContractOuterClass.RuntimeType.WASMER, null);
//            Request.Limit limit = Request.Limit.newBuilder().setGasLimit(10).build();
//            payload = chainClient.attachGasLimit(payload, limit);
            //2. create payloads with endorsement
            Request.EndorsementEntry[] endorsementEntries = SdkUtils.getEndorsers(payload, new User[]{adminUser1, adminUser2, adminUser3});

            // 3. send request
            responseInfo = chainClient.sendContractManageRequest(payload, endorsementEntries, rpcCallTimeout, syncResultTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(responseInfo);
    }

    @Test
    public void testUpgradeContract() {
        ResultOuterClass.TxResponse responseInfo = null;
        try {
            byte[] byteCode = FileUtils.getResourceFileBytes(CONTRACT_FILE_PATH);

            // 1. create payload
            Request.Payload payload = chainClient.createContractUpgradePayload(CONTRACT_NAME, "2", byteCode,
                    ContractOuterClass.RuntimeType.WASMER, null);

            //2. create payloads with endorsement
            Request.EndorsementEntry[] endorsementEntries = SdkUtils.getEndorsers(payload, new User[]{adminUser1, adminUser2, adminUser3});

            // 3. send request
            responseInfo = chainClient.sendContractManageRequest(payload, endorsementEntries, rpcCallTimeout, syncResultTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(responseInfo);
    }

    @Test
    public void testFreezeContract() {
        ResultOuterClass.TxResponse responseInfo = null;
        try {
            // 1. create payload
            Request.Payload payload = chainClient.createContractFreezePayload(CONTRACT_NAME);

            // 2. create payloads with endorsement
            Request.EndorsementEntry[] endorsementEntries = SdkUtils.getEndorsers(payload, new User[]{adminUser1, adminUser2, adminUser3});

            // 3. send request
            responseInfo = chainClient.sendContractManageRequest(payload, endorsementEntries, rpcCallTimeout, syncResultTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(responseInfo);
    }

    @Test
    public void testUnfreezeContract()  {
        ResultOuterClass.TxResponse responseInfo = null;
        try {
            // 1. create payload
            Request.Payload payload = chainClient.createContractUnFreezePayload(CONTRACT_NAME);

            // 2. create payloads with endorsement
            Request.EndorsementEntry[] endorsementEntries = SdkUtils.getEndorsers(payload, new User[]{adminUser1, adminUser2, adminUser3});

            // 3. send request
            responseInfo = chainClient.sendContractManageRequest(payload, endorsementEntries, rpcCallTimeout, syncResultTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(responseInfo);
    }

    @Test
    public void testRevokeContract() {
        ResultOuterClass.TxResponse responseInfo = null;
        try {
            // 1. create payload
            Request.Payload payload = chainClient.createContractRevokePayload(CONTRACT_NAME);

            // 2. create payloads with endorsement
            Request.EndorsementEntry[] endorsementEntries = SdkUtils.getEndorsers(payload, new User[]{adminUser1, adminUser2, adminUser3});

            // 3. send request
            responseInfo = chainClient.sendContractManageRequest(payload, endorsementEntries, rpcCallTimeout, syncResultTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(responseInfo);
    }

    @Test
    public void testInvokeContract() {
        ResultOuterClass.TxResponse responseInfo = null;
        try {
            responseInfo = chainClient.invokeContract(CONTRACT_NAME, INVOKE_CONTRACT_METHOD,
                    null, null, rpcCallTimeout, syncResultTimeout);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(responseInfo);
    }

    @Test
    public void testInvokeContractWithUser() throws ChainMakerCryptoSuiteException {
        String privateKey = "-----BEGIN EC PRIVATE KEY-----\n" +
                "MHcCAQEEILDOGy9q4RVREXzvZ439KuHcbsm/1gxtePuS/1z5WUX+oAoGCCqGSM49\n" +
                "AwEHoUQDQgAEoG8sO7oV1yp0ietNJf78vkvggkEdxxDcdRqkUZIDYjU7rCoLn3BU\n" +
                "oY0MlgZyJFK2317in3eDwNNFPd4cTF9G7w==\n" +
                "-----END EC PRIVATE KEY-----";
        String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
                "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEoG8sO7oV1yp0ietNJf78vkvggkEd\n" +
                "xxDcdRqkUZIDYjU7rCoLn3BUoY0MlgZyJFK2317in3eDwNNFPd4cTF9G7w==\n" +
                "-----END PUBLIC KEY-----\n";
        User user = new User("public",privateKey.getBytes(),"".getBytes(), publicKey.getBytes(), AuthType.Public.getMsg());

        ResultOuterClass.TxResponse responseInfo1 = null;
        Map<String, byte[]> stringMap1 = new HashMap<>();

        stringMap1.put("address", "bb95627d9e4e60d9a5d4be524d4a5f92f377ba4a".getBytes());
        stringMap1.put("level", "1".getBytes());
        stringMap1.put("pkPem", publicKey.getBytes());
        try {
            responseInfo1 = chainClient.invokeContract("identity", "setPermission",
                    "", stringMap1, rpcCallTimeout, syncResultTimeout);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        System.out.println(responseInfo1);
        ResultOuterClass.TxResponse responseInfo = null;
        Map<String, byte[]> stringMap = new HashMap<>();
        String fact_id = random_azAZ09(64);

        stringMap.put("fact_id", fact_id.getBytes());
        stringMap.put("file_hash", ("dsdfddsdslldstrewsa232").getBytes());
        stringMap.put("file_name", "test1".getBytes());
        stringMap.put("user_id", "e4343".getBytes());
        stringMap.put("time", "324564321".getBytes());
        try {
            long gasBalance = chainClient.getGasBalance("bb95627d9e4e60d9a5d4be524d4a5f92f377ba4a", 10000);
            System.out.println("curr：" + gasBalance);
            Request.Payload payload = chainClient.invokeContractPayload(
                    "cmfact", "save_file_hash","",  stringMap);
            long estimateGas = chainClient.estimateGas(payload, 10000);
            System.out.println("estimateGas：" +estimateGas);
//            if (gasBalance < estimateGas) {
//                AccountManager.RechargeGas[] RechargeGasList = new AccountManager.RechargeGas[]{AccountManager.RechargeGas.newBuilder()
//                        .setAddress("bb95627d9e4e60d9a5d4be524d4a5f92f377ba4a")
//                        .setGasAmount(10000).build()};
//                payload = chainClient.createRechargeGasPayload(RechargeGasList);
//
//                // 2. send request
//                responseInfo = chainClient.sendGasManageRequest(payload, null, rpcCallTimeout, syncResultTimeout);
//                System.out.println(responseInfo);
//            }
            Request.Limit limit = Request.Limit.newBuilder().setGasLimit(estimateGas* 2).build();
            payload = chainClient.attachGasLimit(payload, limit);
            responseInfo = chainClient.sendContractRequest(payload, null, 8000L, -1L, user);

//            responseInfo = chainClient.invokeContract("cmfact", "save_file_hash",
//                    fact_id, stringMap, rpcCallTimeout, syncResultTimeout, user);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        System.out.println(responseInfo.toString());
        Assert.assertNotNull(responseInfo);
    }


    public static String random_azAZ09() {
        String[] azAZ = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        return azAZ[random(0, 61)];
    }


    public static int random(int start, int end) {
        return (int)(Math.random() * (double)(end - start + 1) + (double)start);
    }
    public static String random_azAZ09(int length) {
        String result = "";

        for(int n = 0; n < length; ++n) {
            result = result + random_azAZ09();
        }

        return result;
    }
    @Test
    public void testQueryContract() {
        ResultOuterClass.TxResponse responseInfo = null;
        try {
            responseInfo = chainClient.queryContract(CONTRACT_NAME, QUERY_CONTRACT_METHOD,
                    null,  null, rpcCallTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(responseInfo);
    }

    @Test
    public void testQueryContractWithUser() throws ChainMakerCryptoSuiteException {
        String privateKey = "-----BEGIN EC PRIVATE KEY-----\n" +
                "MHcCAQEEILDOGy9q4RVREXzvZ439KuHcbsm/1gxtePuS/1z5WUX+oAoGCCqGSM49\n" +
                "AwEHoUQDQgAEoG8sO7oV1yp0ietNJf78vkvggkEdxxDcdRqkUZIDYjU7rCoLn3BU\n" +
                "oY0MlgZyJFK2317in3eDwNNFPd4cTF9G7w==\n" +
                "-----END EC PRIVATE KEY-----";
        String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
                "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEoG8sO7oV1yp0ietNJf78vkvggkEd\n" +
                "xxDcdRqkUZIDYjU7rCoLn3BUoY0MlgZyJFK2317in3eDwNNFPd4cTF9G7w==\n" +
                "-----END PUBLIC KEY-----\n";
        User user = new User("public",privateKey.getBytes(),"".getBytes(), publicKey.getBytes(), AuthType.Public.getMsg());
        ResultOuterClass.TxResponse responseInfo = null;
        try {
            responseInfo = chainClient.queryContract(CONTRACT_NAME, QUERY_CONTRACT_METHOD,
                    null,  null, rpcCallTimeout, user);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(responseInfo);
    }

}
