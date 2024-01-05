/*
Copyright (C) THL A29 Limited, a Tencent company. All rights reserved.

SPDX-License-Identifier: Apache-2.0
*/
package org.chainmaker.sdk;

import org.chainmaker.pb.common.Request;
import org.chainmaker.pb.common.ResultOuterClass;
import org.chainmaker.sdk.utils.FileUtils;
import org.chainmaker.sdk.utils.SdkUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestPubkeyManage extends TestBase {

    private final String ORG_ID = "wx-org1";
    private final String ROLE = "admin";

    @Test
    public void testPubkeyAdd() {
        ResultOuterClass.TxResponse responseInfo = null;
        try {
            Request.Payload payload = chainClient.createPubkeyAddPayload("", ORG_ID, ROLE);

            Request.EndorsementEntry[] endorsementEntries = SdkUtils.getEndorsers(payload, new User[]{adminUser1, adminUser2, adminUser3});

            responseInfo = chainClient.sendPubkeyManageRequest(payload, endorsementEntries, rpcCallTimeout, syncResultTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(responseInfo);
    }

    @Test
    public void testPubkeyDelete() {
        ResultOuterClass.TxResponse responseInfo = null;
        try {
            Request.Payload payload = chainClient.createPubkeyDelPayload("", ORG_ID);

            Request.EndorsementEntry[] endorsementEntries = SdkUtils.getEndorsers(payload, new User[]{adminUser1, adminUser2, adminUser3});

            responseInfo = chainClient.sendPubkeyManageRequest(payload, endorsementEntries, rpcCallTimeout, syncResultTimeout);
        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(responseInfo);
    }

    @Test
    public void testPubkeyQuery() {
        ResultOuterClass.TxResponse responseInfo = null;
        try {
            String pubkey = new String(FileUtils.getResourceFileBytes(PUB_KEY));
            Request.Payload payload = chainClient.createPubkeyQueryPayload(pubkey);

//            Request.EndorsementEntry[] endorsementEntries = SdkUtils.getEndorsers(payload, new User[]{adminUser1, adminUser2, adminUser3});

//            responseInfo = chainClient.sendPubkeyManageRequest(payload, null, rpcCallTimeout, syncResultTimeout);
//            responseInfo = chainClient.sendRequest(payload, null, rpcCallTimeout);

        } catch (SdkException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        System.out.println(responseInfo);
        Assert.assertNotNull(responseInfo);
    }
}
