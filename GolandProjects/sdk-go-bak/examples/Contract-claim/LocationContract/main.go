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
	claimContractName        = "LocationContract"
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
	for i := 0; i < 50; i++ {
		go dosome(client)
	}
	for tag != 50 {
	}
	allTime := time.Now().UnixNano()/1e6 - startTime
	fmt.Println(tag)
	fmt.Println(allTime)
	fmt.Println(tag * 1000 / allTime)
}

func dosome(client *sdk.ChainClient) {
	testUserContractClaim(client)
	tag++
}

func testUserContractClaim(client *sdk.ChainClient) {
	//fmt.Println("====================== 调用Location合约AddLocation接口 ======================")
	//wid, err := testUserContractClaimInvoke1(client, "AddLocation", true)
	//fmt.Println(wid)
	//if err != nil {
	//	log.Fatalln(err)
	//}

	//fmt.Println("====================== 调用Location合约UpdateLocation接口 ======================")
	//wid, err := testUserContractClaimInvoke2(client, "UpdateLocation", true)
	//fmt.Println(wid)
	//if err != nil {
	//	log.Fatalln(err)
	//}

	fmt.Println("====================== 调用Location合约DeleteLocation接口 ======================")
	wid, err := testUserContractClaimInvoke3(client, "DeleteLocation", true)
	fmt.Println(wid)
	if err != nil {
		log.Fatalln(err)
	}

	//fmt.Println("====================== 调用Location合约QueryLocation接口 ======================")
	//wid, err := testUserContractClaimInvoke4(client, "QueryLocation", true)
	//fmt.Println(wid)
	//if err != nil {
	//	log.Fatalln(err)
	//}
}

func testUserContractClaimInvoke1(client *sdk.ChainClient,
	method string, withSyncResult bool) (string, error) {

	wid := "8"
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

func testUserContractClaimInvoke2(client *sdk.ChainClient,
	method string, withSyncResult bool) (string, error) {

	wid := "8"
	message := "newmessage"
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

func testUserContractClaimInvoke3(client *sdk.ChainClient,
	method string, withSyncResult bool) (string, error) {

	wid := "8"
	kvs := []*common.KeyValuePair{
		{
			Key:   "wid",
			Value: []byte(wid),
		},
	}

	err := invokeUserContract(client, claimContractName, method, "", kvs, withSyncResult)
	if err != nil {
		return "", err
	}

	return wid, nil
}

func testUserContractClaimInvoke4(client *sdk.ChainClient,
	method string, withSyncResult bool) (string, error) {

	wid := "8"
	kvs := []*common.KeyValuePair{
		{
			Key:   "wid",
			Value: []byte(wid),
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
