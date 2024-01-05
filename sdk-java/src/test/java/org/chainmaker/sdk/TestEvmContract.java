/*
Copyright (C) THL A29 Limited, a Tencent company. All rights reserved.

SPDX-License-Identifier: Apache-2.0
*/

package org.chainmaker.sdk;

import java.security.NoSuchAlgorithmException;

import org.chainmaker.pb.common.ChainmakerTransaction;
import org.chainmaker.pb.common.ContractOuterClass;
import org.chainmaker.pb.common.Request;
import org.chainmaker.pb.common.ResultOuterClass;
import org.chainmaker.sdk.crypto.ChainMakerCryptoSuiteException;
import org.chainmaker.sdk.utils.CryptoUtils;
import org.chainmaker.sdk.utils.FileUtils;
import org.chainmaker.sdk.utils.SdkUtils;
import org.chainmaker.sdk.utils.Utils;
import org.chainmaker.sdk.utils.UtilsException;
import org.junit.Assert;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.abi.*;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.utils.Numeric;

import java.math.BigInteger;
import java.util.*;


public class TestEvmContract extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(TestEvmContract.class);

    private static final String EVM_CONTRACT_FILE_PATH = "token.bin";
    private static final String CONTRACT_NAME = "token101";
    private static final String CONTRACT_ARGS_EVM_PARAM = "data";
    private static String ADDRESS = "";

    private void makeAddrFromCert() {
        try {
            //公钥模式下，请替换ADDRESS的生成方式，通过公钥生成ADDRESS
//            ADDRESS = CryptoUtils.makeAddrFromPukPem(chainClient.getClientUser().getPublicKey());
            ADDRESS = CryptoUtils.makeAddrFromCert(chainClient.getClientUser().getCertificate());
        } catch (UtilsException e) {
            e.printStackTrace();
        }
        // 2.3.0
//        ADDRESS = CryptoUtils.PkToAddrStr(chainClient.getClientUser().getPublicKey(), ChainConfigOuterClass.AddrType.ETHEREUM, "SHA256");
//        try {
//            ADDRESS = CryptoUtils.CertToAddrStr(chainClient.getClientUser().getCertificate(), ChainConfigOuterClass.AddrType.ETHEREUM);
//        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
//            throw new RuntimeException(e);
//        }
    }


    @Test
    public void testCreateEvmContract() {
        makeAddrFromCert();
        //创建合约构造参数扽RLP编码值
        Function function = new Function("", Arrays.asList(new Address(ADDRESS)),
                Collections.emptyList());
        String methodDataStr = FunctionEncoder.encode(function);

        Map<String, byte[]> paramMap = new HashMap<>();
        paramMap.put(CONTRACT_ARGS_EVM_PARAM, methodDataStr.substring(10).getBytes());


        ResultOuterClass.TxResponse responseInfo = null;
        try {
            byte[] byteCode = FileUtils.getResourceFileBytes(EVM_CONTRACT_FILE_PATH);
            // 1. create payload
            Request.Payload payload = chainClient.createContractCreatePayload(Utils.calcContractName(CONTRACT_NAME),
                    "1", byteCode,
                    ContractOuterClass.RuntimeType.EVM, paramMap);

            //2. create payloads with endorsement
            Request.EndorsementEntry[] endorsementEntries = SdkUtils.getEndorsers(
                    payload, new User[]{adminUser1, adminUser2, adminUser3});

            // 3. send request
            responseInfo = chainClient.sendContractManageRequest(
                    payload, endorsementEntries, rpcCallTimeout, syncResultTimeout);
            System.out.println(responseInfo);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(responseInfo);
    }


    @Test
    public void testUpgradeEvmContract() {
        ResultOuterClass.TxResponse responseInfo = null;
        try {
            byte[] byteCode = FileUtils.getResourceFileBytes(EVM_CONTRACT_FILE_PATH);

            // 1. create payload
            Request.Payload payload = chainClient.createContractUpgradePayload(Utils.calcContractName(CONTRACT_NAME), "2", byteCode,
                    ContractOuterClass.RuntimeType.EVM, null);

            //2. create payloads with endorsement
            Request.EndorsementEntry[] endorsementEntries = SdkUtils.getEndorsers(payload, new User[]{adminUser1, adminUser2, adminUser3});

            // 3. send request
            responseInfo = chainClient.sendContractManageRequest(payload, endorsementEntries, rpcCallTimeout, syncResultTimeout);
            System.out.println(responseInfo);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(responseInfo);
    }


    @Test
    public void testInvokeTransferEvmContract() throws UtilsException, NoSuchAlgorithmException {
        Map<String, byte[]> params = new HashMap<>();
        String toAddress = CryptoUtils.makeAddrFromCert(adminUser2.getTlsCertificate());
        BigInteger amount = BigInteger.valueOf(600);
        Function function = new Function("transfer", Arrays.asList(new Address(toAddress), new Uint256(amount)),
                Collections.emptyList());

        String methodDataStr = FunctionEncoder.encode(function);
        String method = methodDataStr.substring(0, 10);
        params.put(CONTRACT_ARGS_EVM_PARAM, methodDataStr.getBytes());

        ResultOuterClass.TxResponse responseInfo = null;
        try {
            responseInfo = chainClient.invokeContract(Utils.calcContractName(CONTRACT_NAME),
                    method, null, params, rpcCallTimeout, syncResultTimeout);
            System.out.println(responseInfo);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(responseInfo);
    }

    @Test
    public void testInvokeBalanceOfEvmContract() throws UtilsException, ChainClientException, ChainMakerCryptoSuiteException {
        makeAddrFromCert();
        Map<String, byte[]> params = new HashMap<>();


        // Address from =new Address( CryptoUtils.makeAddrFromCert(adminUser2.getTlsCertificate()));
        Address to = new Address(ADDRESS);
        Function function = new Function("balanceOf", Arrays.asList(to),
                Collections.emptyList());

        String methodDataStr = FunctionEncoder.encode(function);
        String method = methodDataStr.substring(0, 10);
        params.put(CONTRACT_ARGS_EVM_PARAM, methodDataStr.getBytes());
        ResultOuterClass.TxResponse responseInfo = null;
        try {
            responseInfo = chainClient.invokeContract(Utils.calcContractName(CONTRACT_NAME),
                    method, null, params, rpcCallTimeout, syncResultTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(responseInfo);

        //查询本次交易结果
        ChainmakerTransaction.TransactionInfo tx = chainClient.getTxByTxId(responseInfo.getTxId(), rpcCallTimeout);


        //解析参数
        Request.KeyValuePair keyValuePair = tx.getTransaction().getPayload().getParameters(0);
        String v = keyValuePair.getValue().toStringUtf8().substring(10).toString();
        Function f = new Function("balanceOf", Collections.emptyList(), Arrays.asList(new TypeReference<Address>() {
        }));

        //传递参数与解析结果参数一致
        Assert.assertEquals(to.getValue(), FunctionReturnDecoder.decode(v, f.getOutputParameters()).get(0).getValue());
        logger.info("传递参数:{},解析参数：{}", to.getValue(), FunctionReturnDecoder.decode(v, f.getOutputParameters()).get(0).getValue());

        //解析结果数据
        ResultOuterClass.ContractResult contractResult = tx.getTransaction().getResult().getContractResult();

        //合约执行结果  与查询交易结果一致
        Assert.assertEquals(Numeric.toBigInt(responseInfo.getContractResult().getResult().toByteArray()),
                Numeric.toBigInt(contractResult.getResult().toByteArray()));

        logger.info("调用合约结果：{},查询交易合约执行结果:{}", Numeric.toBigInt(responseInfo.getContractResult().getResult().toByteArray()),
                Numeric.toBigInt(responseInfo.getContractResult().getResult().toByteArray()));
    }


}
