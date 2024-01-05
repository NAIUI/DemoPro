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

type LocationContract struct {
}

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

// InitContract 初始化合约SDK
func (f *LocationContract) InitContract() protogo.Response {
	return sdk.Success([]byte("Init contract success"))
}

// UpgradeContract 更新合约SDK
func (f *LocationContract) UpgradeContract() protogo.Response {
	return sdk.Success([]byte("Upgrade contract success"))
}

// InvokeContract 调用合约接口链接SDK
func (f *LocationContract) InvokeContract(method string) protogo.Response {
	switch method {
	case "AddLocation":
		return f.AddLocation()
	case "UpdateLocation":
		return f.UpdateLocation()
	case "DeleteLocation":
		return f.DeleteLocation()
	case "QueryLocation":
		return f.QueryLocation()
	default:
		return sdk.Error("invalid method")
	}
}

func (f *LocationContract) AddLocation() protogo.Response {
	params := sdk.Instance.GetArgs()

	// 获取参数
	wid := string(params["wid"])
	message := string(params["message"])
	tistr := string(params["ti"])
	state := string(params["state"])
	ti, err := strconv.Atoi(tistr)
	if err != nil {
		msg := "time is [" + tistr + "] not int"
		sdk.Instance.Errorf(msg)
		return sdk.Error(msg)
	}

	// 构建结构体
	location := NewLocation(wid, message, int64(ti), state)

	// 序列化
	locationBytes, err := json.Marshal(location)
	if err != nil {
		return sdk.Error(fmt.Sprintf("marshal location failed, err: %s", err))
	}
	// 发送事件
	sdk.Instance.EmitEvent("AddLocation", []string{location.Wid, location.EpkXi, tistr, location.State})

	// 存储数据
	err = sdk.Instance.PutStateByte("location_bytes", location.Wid, locationBytes)
	if err != nil {
		return sdk.Error("fail to save location bytes")
	}

	// 记录日志
	sdk.Instance.Infof("[save] wid=" + location.Wid)
	sdk.Instance.Infof("[save] message=" + location.EpkXi)
	sdk.Instance.Infof("[save] ti=" + tistr)
	sdk.Instance.Infof("[save] state=" + location.State)

	// 更新工人集合
	// 查询集合
	crossContractArgs := make(map[string][]byte)
	res := sdk.Instance.CallContract("TaskContract", "QueryWorkerList", crossContractArgs)
	r := res.GetPayload()
	sdk.Instance.Infof("result=" + string(r))
	result := string(r)
	// 更新集合
	result += location.Wid + " "
	crossContractArgs2 := make(map[string][]byte)
	crossContractArgs2["workerList"] = []byte(result)
	sdk.Instance.CallContract("TaskContract", "UpdateWorkerList", crossContractArgs2)
	// 记录日志
	sdk.Instance.Infof("[update] workerList=" + result)

	// 返回结果
	return sdk.Success([]byte(location.Wid + location.EpkXi + tistr + location.State + "   workerList: " + result))

}

func (f *LocationContract) UpdateLocation() protogo.Response {
	params := sdk.Instance.GetArgs()

	// 获取参数
	wid := string(params["wid"])
	message := string(params["message"])
	tistr := string(params["ti"])
	state := string(params["state"])
	ti, err := strconv.Atoi(tistr)
	if err != nil {
		msg := "time is [" + tistr + "] not int"
		sdk.Instance.Errorf(msg)
		return sdk.Error(msg)
	}

	// 构建结构体
	location := NewLocation(wid, message, int64(ti), state)

	// 序列化
	locationBytes, err := json.Marshal(location)
	if err != nil {
		return sdk.Error(fmt.Sprintf("marshal location failed, err: %s", err))
	}
	// 发送事件
	sdk.Instance.EmitEvent("UpdateLocation", []string{location.Wid, location.EpkXi, tistr, location.State})

	// 存储数据
	err = sdk.Instance.PutStateByte("location_bytes", location.Wid, locationBytes)
	if err != nil {
		return sdk.Error("fail to update location bytes")
	}

	// 记录日志
	sdk.Instance.Infof("[update] wid=" + location.Wid)
	sdk.Instance.Infof("[update] message=" + location.EpkXi)
	sdk.Instance.Infof("[update] ti" + tistr)
	sdk.Instance.Infof("[update state]" + location.State)

	// 返回结果
	return sdk.Success([]byte(location.Wid))
}

func (f *LocationContract) DeleteLocation() protogo.Response {
	// 获取参数
	wid := string(sdk.Instance.GetArgs()["wid"])

	// 删除位置信息
	result, err := sdk.Instance.GetStateByte("location_bytes", wid)
	if err != nil {
		return sdk.Error("failed to call get_state" + string(result))
	}
	err = sdk.Instance.DelState("location_bytes", wid)
	if err != nil {
		return sdk.Error("failed to delete location_bytes_" + wid)
	}

	// 记录日志
	sdk.Instance.Infof("[delete] location_bytes_wid=" + wid)

	// 返回结果
	return sdk.Success(nil)
}

func (f *LocationContract) QueryLocation() protogo.Response {
	// 获取参数
	wid := string(sdk.Instance.GetArgs()["wid"])

	// 查询结果
	result, err := sdk.Instance.GetStateByte("location_bytes", wid)
	if err != nil {
		return sdk.Error("failed to call get_state")
	}

	// 反序列化
	var location Location
	if err = json.Unmarshal(result, &location); err != nil {
		return sdk.Error(fmt.Sprintf("unmarshal location failed, err: %s", err))
	}

	// 记录日志
	sdk.Instance.Infof("[query] wid=" + location.Wid)
	sdk.Instance.Infof("[query] message=" + location.EpkXi)
	sdk.Instance.Infof("[query] ti=" + strconv.FormatInt(location.Ti, 10))
	sdk.Instance.Infof("[query] state=" + location.State)

	// 返回结果
	return sdk.Success(result)
}

func main() {
	err := sandbox.Start(new(LocationContract))
	if err != nil {
		log.Fatal(err)
	}
}
