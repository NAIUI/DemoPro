package main

import (
	"chainmaker.org/chainmaker/contract-sdk-go/v2/pb/protogo"
	"chainmaker.org/chainmaker/contract-sdk-go/v2/sandbox"
	"chainmaker.org/chainmaker/contract-sdk-go/v2/sdk"
	"encoding/json"
	"fmt"
	"log"
	"strconv"
)

// Location 工人位置信息对象
type Location struct {
	Wid   string `json:"wid"`     // 工人id
	EpkXi string `json:"message"` // 工人加密的位置坐标信息
	Ti    int64  `json:"ti"`      // 工人位置的有效时间
	State string `json:"state"`   // 工人状态
}

// NewLocation 新建工人位置信息对象
func NewLocation(wid string, message string, ti int64, state string) *Location {
	location := &Location{
		Wid:   wid,
		EpkXi: message,
		Ti:    ti,
		State: state,
	}
	return location
}

type ResultContract struct {
}

// InitContract 初始化合约SDK
func (f *ResultContract) InitContract() protogo.Response {
	return sdk.Success([]byte("Init contract success"))
}

// UpgradeContract 更新合约SDK
func (f *ResultContract) UpgradeContract() protogo.Response {
	return sdk.Success([]byte("Upgrade contract success"))
}

// InvokeContract 调用合约接口链接SDK
func (f *ResultContract) InvokeContract(method string) protogo.Response {
	switch method {
	case "UploadResult":
		return f.UploadResult()
	default:
		return sdk.Error("invalid method")
	}
}

func (f *ResultContract) UploadResult() protogo.Response {
	// 获取参数
	result := string(sdk.Instance.GetArgs()["result"])

	// 查询结果
	// 查询工人
	crossContractArgs1 := make(map[string][]byte)
	crossContractArgs1["wid"] = []byte(result)
	res := sdk.Instance.CallContract("LocationContract", "QueryLocation", crossContractArgs1)

	var location Location
	r := res.GetPayload()
	if err := json.Unmarshal(r, &location); err != nil {
		return sdk.Error(fmt.Sprintf("unmarshal location failed, err: %s", err))
	}
	newstate := "busy"

	crossContractArgs2 := make(map[string][]byte)
	crossContractArgs2["wid"] = []byte(location.Wid)
	crossContractArgs2["message"] = []byte(location.EpkXi)
	crossContractArgs2["ti"] = []byte(strconv.FormatInt(location.Ti, 10))
	crossContractArgs2["state"] = []byte(newstate)
	sdk.Instance.CallContract("LocationContract", "UpdateLocation", crossContractArgs2)

	// 记录日志
	sdk.Instance.Infof("[save] result=" + result)

	// 返回结果
	return sdk.Success([]byte(result))
}

func main() {
	err := sandbox.Start(new(ResultContract))
	if err != nil {
		log.Fatal(err)
	}
}
