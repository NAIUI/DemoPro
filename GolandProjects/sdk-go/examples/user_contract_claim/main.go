/*
Copyright (C) BABEC. All rights reserved.
Copyright (C) THL A29 Limited, a Tencent company. All rights reserved.

SPDX-License-Identifier: Apache-2.0
*/

package main

import (
	"chainmaker.org/chainmaker/pb-go/v2/common"
	sdk "chainmaker.org/chainmaker/sdk-go/v2"
	"chainmaker.org/chainmaker/sdk-go/v2/examples"
	"fmt"
	"log"
	"time"
)

const (
	createContractTimeout = 5
	claimContractName     = "LocationContract"
	claimVersion          = "v1.0.0"
	claimByteCodePath     = "D:\\project\\GolandProjects\\sdk-go\\testdata\\claim-wasm-demo\\rust-fact-2.0.0.wasm"

	sdkConfigOrg1Client1Path = "D:\\project\\GolandProjects\\sdk-go\\examples\\sdk_configs\\sdk_config_org1_client1.yml"
)

var tag int64 = 1

func main() {

	fmt.Println("====================== create client ======================")
	client, err := examples.CreateChainClientWithSDKConf(sdkConfigOrg1Client1Path)
	if err != nil {
		log.Fatalln(err)
	}
	startTime := time.Now().UnixNano() / 1e6
	for i := 0; i < 2; i++ {
		go dosome(client)
	}
	for tag != 2 {
	}
	allTime := time.Now().UnixNano()/1e6 - startTime
	fmt.Println(tag)
	fmt.Println(allTime)
	fmt.Println(tag * 1000 / allTime)
	//testUserContractClaim(client)
}

func dosome(client *sdk.ChainClient) {
	testUserContractClaim(client)
	tag++
}

func testUserContractClaim(client *sdk.ChainClient) {

	//fmt.Println("====================== 创建合约 ======================")
	//usernames := []string{examples.UserNameOrg1Admin1, examples.UserNameOrg2Admin1, examples.UserNameOrg3Admin1, examples.UserNameOrg4Admin1}
	//testUserContractClaimCreate(client, true, usernames...)

	//fmt.Println("====================== 调用合约 ======================")
	//wid, err := testUserContractClaimInvoke(client, "AddLocation", true)
	//wid, err := testUserContractClaimInvoke(client, "UpdateLocation", true)
	//fmt.Println(wid)
	//if err != nil {
	//	log.Fatalln(err)
	//}

	wid := "id001"
	fmt.Println("====================== 执行合约查询接口 ======================")
	kvs := []*common.KeyValuePair{
		{
			Key:   "wid",
			Value: []byte(wid),
		},
	}

	//testUserContractClaimQuery(client, "DeleteLocation", kvs)
	testUserContractClaimQuery(client, "QueryLocation", kvs)

	//====================== 创建合约 ======================
	//CREATE claim contract resp: message:"OK" contract_result:<result:"\n\010claim001\022\0052.0.0\030\002*<\n\026wx-org1.chainmaker.org\020\001\032 $p^\215Q\366\236\2120\007\233eW\210\220\3746\250\027\331h\212\024\253\370Ecl\214J'\322" message:"OK" > tx_id:"e40e126cf093472bbb1c80cbd9e6c18ef64e0f8e276046a38f7cc98df1d0cba7"
	//====================== 调用合约 ======================
	//invoke contract success, resp: [code:0]/[msg:OK]/[contractResult:gas_used:14538222 ]
	//====================== 执行合约查询接口 ======================
	//QUERY claim contract resp: message:"SUCCESS" contract_result:<result:"{\"file_hash\":\"8f4c3500833040919ea63bfe1059e117\",\"file_name\":\"file_2021-07-20 19:47:24\",\"time\":\"2021-07-20 19:47:24\"}" gas_used:24597022 > tx_id:"154d3f1bb53d432098de1664b5dbdbfa1e1420cdb4634bd3ba92431ce037ca29"
}

func testUserContractClaimCreate(client *sdk.ChainClient, withSyncResult bool, usernames ...string) {

	resp, err := createUserContract(client, claimContractName, claimVersion, claimByteCodePath,
		common.RuntimeType_WASMER, []*common.KeyValuePair{}, withSyncResult, usernames...)
	if err != nil {
		log.Fatalln(err)
	}

	fmt.Printf("CREATE claim contract resp: %+v\n", resp)
}

func createUserContract(client *sdk.ChainClient, contractName, version, byteCodePath string, runtime common.RuntimeType,
	kvs []*common.KeyValuePair, withSyncResult bool, usernames ...string) (*common.TxResponse, error) {

	payload, err := client.CreateContractCreatePayload(contractName, version, byteCodePath, runtime, kvs)
	if err != nil {
		return nil, err
	}

	//endorsers, err := examples.GetEndorsers(payload, usernames...)
	endorsers, err := examples.GetEndorsersWithAuthType(client.GetHashType(),
		client.GetAuthType(), payload, usernames...)
	if err != nil {
		return nil, err
	}

	resp, err := client.SendContractManageRequest(payload, endorsers, createContractTimeout, withSyncResult)
	if err != nil {
		return nil, err
	}

	err = examples.CheckProposalRequestResp(resp, true)
	if err != nil {
		return nil, err
	}

	return resp, nil
}

func testUserContractClaimInvoke(client *sdk.ChainClient,
	method string, withSyncResult bool) (string, error) {

	wid := "id001"
	message := "message"
	ti := "20221128"
	state := "free"
	kvs := []*common.KeyValuePair{
		{
			Key:   "wid",
			Value: []byte(wid),
		},
		{
			Key:   "message",
			Value: []byte(message),
		},
		{
			Key:   "ti",
			Value: []byte(ti),
		},
		{
			Key:   "state",
			Value: []byte(state),
		},
	}

	err := invokeUserContract(client, claimContractName, method, "", kvs, withSyncResult)
	if err != nil {
		return "", err
	}

	return wid, nil
}

func invokeUserContract(client *sdk.ChainClient, contractName, method, txId string,
	kvs []*common.KeyValuePair, withSyncResult bool) error {

	resp, err := client.InvokeContract(contractName, method, txId, kvs, -1, false)
	if err != nil {
		return err
	}

	if resp.Code != common.TxStatusCode_SUCCESS {
		return fmt.Errorf("invoke contract failed, [code:%d]/[msg:%s]\n", resp.Code, resp.Message)
	}

	if !withSyncResult {
		fmt.Printf("invoke contract success, resp: [code:%d]/[msg:%s]/[txId:%s]\n", resp.Code, resp.Message, resp.ContractResult.Result)
	} else {
		fmt.Printf("invoke contract success, resp: [code:%d]/[msg:%s]/[contractResult:%s]\n", resp.Code, resp.Message, resp.ContractResult)
	}

	return nil
}

func testUserContractClaimQuery(client *sdk.ChainClient, method string, kvs []*common.KeyValuePair) {
	resp, err := client.QueryContract(claimContractName, method, kvs, -1)
	if err != nil {
		log.Fatalln(err)
	}

	fmt.Printf("QUERY claim contract resp: %+v\n", resp)
}
