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
	claimContractName        = "ResultContract"
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
	for i := 0; i < 100; i++ {
		go dosome(client)
	}
	for tag != 100 {
	}
	allTime := time.Now().UnixNano()/1e6 - startTime
	fmt.Println(tag)
	fmt.Println(allTime)
	fmt.Println(tag * 1000 / allTime)
}

func dosome(client *sdk.ChainClient) {
	for i := 0; i < 10; i++ {
		testUserContractClaim(client)
	}
	tag++
}

func testUserContractClaim(client *sdk.ChainClient) {
	fmt.Println("====================== 调用Result合约UploadResult接口 ======================")
	wid, err := testUserContractClaimInvoke(client, "UploadResult", true)
	fmt.Println(wid)
	if err != nil {
		log.Fatalln(err)
	}
}

func testUserContractClaimInvoke(client *sdk.ChainClient,
	method string, withSyncResult bool) (string, error) {

	result := "id004"
	kvs := []*common.KeyValuePair{
		{
			Key:   "result",
			Value: []byte(result),
		},
	}

	err := invokeUserContract(client, claimContractName, method, "", kvs, withSyncResult)
	if err != nil {
		return "", err
	}

	return result, nil
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
