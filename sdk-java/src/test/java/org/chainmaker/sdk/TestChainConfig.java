/*
Copyright (C) THL A29 Limited, a Tencent company. All rights reserved.

SPDX-License-Identifier: Apache-2.0
*/

package org.chainmaker.sdk;

import org.chainmaker.pb.accesscontrol.PolicyOuterClass;
import org.chainmaker.pb.common.Request;
import org.chainmaker.pb.common.ResultOuterClass;
import org.chainmaker.pb.config.ChainConfigOuterClass;
import org.chainmaker.sdk.utils.FileUtils;
import org.chainmaker.sdk.utils.SdkUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.utils.Numeric;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestChainConfig extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(TestChainConfig.class);

    private final String ORG_ID = "wx-org1";
    private final String NODE_ID = "QmQVkTSF6aWzRSddT3rro6Ve33jhKpsHFaQoVxHKMWzhuN";

    @Test
    public void testGetChainConfig() {
        ChainConfigOuterClass.ChainConfig chainConfig = null;
        try {
            chainConfig = chainClient.getChainConfig(rpcCallTimeout);
            logger.info(chainConfig.getVersion());
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(chainConfig.toString());
    }

    @Test
    public void testGetChainConfigByBlockHeight() {
        ChainConfigOuterClass.ChainConfig chainConfig = null;
        try {
            chainConfig = chainClient.getChainConfigByBlockHeight(3, rpcCallTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(chainConfig.toString());
    }

    @Test
    public void testGetChainConfigSequence() {
        long sequence = 0;
        try {
            sequence = chainClient.getChainConfigSequence(20000);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotEquals(-1, sequence);
    }

    @Test
    public void testCreatePayloadOfChainConfigCoreUpdate() {
        Request.Payload payload = null;
        try {
            payload = chainClient.createPayloadOfChainConfigCoreUpdate(20, 30, rpcCallTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(payload);
    }

    @Test
    public void testCreatePayloadOfChainConfigBlockUpdate() {
        Request.Payload payload = null;
        try {
            payload = chainClient.createPayloadOfChainConfigBlockUpdate(false,
                    800, 1000, 1000, 5000, 20, rpcCallTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(payload);
    }

    @Test
    public void testCreatePayloadOfChainConfigTrustRootAdd() {
        Request.Payload payload = null;

        try {
            String[] certList = new String[]{new String(FileUtils.getResourceFileBytes(ADMIN2_CERT_PATH))};
            payload = chainClient.createPayloadOfChainConfigTrustRootAdd(ORG_ID, certList, rpcCallTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(payload);
    }

    @Test
    public void testCreatePayloadOfChainConfigTrustRootUpdate() {
        Request.Payload payload = null;
        try {
            String[] certList = new String[]{new String(FileUtils.getResourceFileBytes(ADMIN2_CERT_PATH))};
            payload = chainClient.createPayloadOfChainConfigTrustRootUpdate(ORG_ID, certList, rpcCallTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(payload);
    }

    @Test
    public void testCreatePayloadOfChainConfigTrustRootDelete() {
        Request.Payload payload = null;
        try {
            payload = chainClient.createPayloadOfChainConfigTrustRootDelete(ORG_ID, rpcCallTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(payload);
    }

    @Test
    public void testCreatePayloadOfChainConfigPermissionAdd() {
        Request.Payload payload = null;
        try {
            payload = chainClient.createPayloadOfChainConfigPermissionAdd(ORG_ID,
                    PolicyOuterClass.Policy.getDefaultInstance(), rpcCallTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(payload);
    }

    @Test
    public void testCreatePayloadOfChainConfigPermissionUpdate() {
        Request.Payload payload = null;
        try {
            payload = chainClient.createPayloadOfChainConfigPermissionUpdate(ORG_ID,
                    PolicyOuterClass.Policy.getDefaultInstance(), rpcCallTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(payload);
    }

    @Test
    public void testCreatePayloadOfChainConfigPermissionDelete() {
        Request.Payload payload = null;
        try {
            payload = chainClient.createPayloadOfChainConfigPermissionDelete(ORG_ID, rpcCallTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(payload);
    }

    @Test
    public void testCreatePayloadOfChainConfigConsensusNodeAddrAdd() {
        Request.Payload payload = null;
        try {
            payload = chainClient.createPayloadOfChainConfigConsensusNodeAddrAdd(ORG_ID,
                    new String[]{NODE_ID}, rpcCallTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(payload);
    }

    @Test
    public void testCreatePayloadOfChainConfigConsensusNodeAddrUpdate() {
        Request.Payload payload = null;
        try {
            payload = chainClient.createPayloadOfChainConfigConsensusNodeAddrUpdate(ORG_ID,
                    NODE_ID, NODE_ID, rpcCallTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(payload);
    }

    @Test
    public void testCreatePayloadOfChainConfigConsensusNodeAddrDelete() {
        Request.Payload payload = null;
        try {
            payload = chainClient.createPayloadOfChainConfigConsensusNodeAddrDelete(ORG_ID,
                    NODE_ID, rpcCallTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(payload);
    }

    @Test
    public void testCreatePayloadOfChainConfigConsensusNodeOrgAdd() {
        Request.Payload payload = null;
        try {
            payload = chainClient.createPayloadOfChainConfigConsensusNodeOrgAdd(ORG_ID,
                    new String[]{NODE_ID}, rpcCallTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(payload);
    }

    @Test
    public void testCreatePayloadOfChainConfigConsensusNodeOrgUpdate() {
        Request.Payload payload = null;
        try {
            payload = chainClient.createPayloadOfChainConfigConsensusNodeOrgUpdate(ORG_ID,
                    new String[]{NODE_ID}, rpcCallTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(payload);
    }

    @Test
    public void testCreateChainConfigConsensusNodeOrgDeletePayload() {
        Request.Payload payload = null;
        try {
            payload = chainClient.createPayloadOfChainConfigConsensusNodeOrgDelete(ORG_ID, rpcCallTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(payload);
    }

    @Test
    public void testCreatePayloadOfChainConfigConsensusExtAdd() {
        Map<String, byte[]> params = new HashMap<>();
        params.put("aaaa", "bbbb".getBytes());
        Request.Payload payload = null;
        try {
            payload = chainClient.createPayloadOfChainConfigConsensusExtAdd(params, rpcCallTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(payload);
    }

    @Test
    public void testCreatePayloadOfChainConfigConsensusExtUpdatePayload() {
        Map<String, byte[]> params = new HashMap<>();
        params.put("aaaa", "bbbb".getBytes());
        Request.Payload payload = null;
        try {
            payload = chainClient.createPayloadOfChainConfigConsensusExtUpdate(params, rpcCallTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(payload);
    }

    @Test
    public void testCreatePayloadOfChainConfigConsensusExtDelete() {
        Request.Payload payload = null;
        try {
            payload = chainClient.createPayloadOfChainConfigConsensusExtDelete(new String[]{"aaaa"}, rpcCallTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(payload);
    }

    @Test
    public void testUpdateChainConfig() {
        ResultOuterClass.TxResponse responseInfo = null;
        try {
            Request.Payload payload = chainClient.createPayloadOfChainConfigBlockUpdate(false,
                    9001, 200, 225, 2000, 20, rpcCallTimeout);
            Request.EndorsementEntry[] endorsementEntries = SdkUtils.getEndorsers(payload,
                    new User[]{adminUser1, adminUser2, adminUser3});
            responseInfo = chainClient.updateChainConfig(payload, endorsementEntries,
                    rpcCallTimeout, syncResultTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(responseInfo);
    }

    @Test
    public void testChainConfigGasEnable() {
        Request.Payload payload;

        ResultOuterClass.TxResponse responseInfo = null;
        try {
            // 1. create payload
            payload = chainClient.createChainConfigEnableOrDisableGasPayload(rpcCallTimeout);
            //2. create payloads with endorsement
            Request.EndorsementEntry[] endorsementEntries = SdkUtils
                    .getEndorsers(payload, new User[]{adminUser1, adminUser2, adminUser3});

            // 3. send request
            responseInfo = chainClient.sendGasManageRequest(payload, endorsementEntries, rpcCallTimeout, syncResultTimeout);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(responseInfo);
    }


    /**
     * 3.27  测试开启或关闭链配置的Gas优化
     */
    @Test
    public void testChainConfigOptimizeChargeGasEnable() {
        Request.Payload payload;

        ResultOuterClass.TxResponse responseInfo = null;
        try {
            // 1. create payload
            payload = chainClient.createChainConfigOptimizeChargeGasPayload(false, rpcCallTimeout);

            logger.debug("参数个数:{}", payload.getParametersCount());
            Assert.assertEquals(1, payload.getParametersCount());

            logger.debug("参数值:{}", Boolean.parseBoolean(new String(payload.getParameters(0).getValue().toByteArray())));
            Assert.assertEquals(false, Boolean.parseBoolean(new String(payload.getParameters(0).getValue().toByteArray())));

            //先打开开关，才能启动优化,第二次执行时需要关闭。避免被关闭掉。
            payload = chainClient.createChainConfigEnableOrDisableGasPayload(rpcCallTimeout);

            //2. create payloads with endorsement
            Request.EndorsementEntry[] endorsementEntries = SdkUtils
                    .getEndorsers(payload, new User[]{adminUser1, adminUser2, adminUser3});

            // 3. send request
            responseInfo = chainClient.sendGasManageRequest(payload, endorsementEntries, rpcCallTimeout, syncResultTimeout);

            ChainConfigOuterClass.ChainConfig chainConfig = ChainConfigOuterClass.ChainConfig.parseFrom(responseInfo.getContractResult().getResult().toByteArray());
            logger.debug("解析结果：{}", chainConfig.getCore().getEnableOptimizeChargeGas());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        //Assert.assertNotNull(responseInfo);
    }

    /**
     * 3.28  查询最新权限配置列表
     */
    @Test
    public void testGetChainConfigPermissionList() {
        logger.debug("[SDK] begin to get chain config permission list");
        try {
            List<ChainConfigOuterClass.ResourcePolicy> list = chainClient.getChainConfigPermissionList(rpcCallTimeout);
            logger.debug("权限列表：{}", list);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

}
