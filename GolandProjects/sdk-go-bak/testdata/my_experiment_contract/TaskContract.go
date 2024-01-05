package main

import (
	"chainmaker.org/chainmaker/contract-sdk-go/v2/pb/protogo"
	"chainmaker.org/chainmaker/contract-sdk-go/v2/sandbox"
	"chainmaker.org/chainmaker/contract-sdk-go/v2/sdk"
	"encoding/json"
	"fmt"
	"log"
	"strconv"
	"strings"
)

type TaskContract struct {
}

// Task 任务信息对象
type Task struct {
	Rid    string `json:"rid"`    // 请求者id
	Tid    string `json:"tid"`    // 任务id
	Reward string `json:"reward"` // 任务设置的奖励
	T_beg  int64  `json:"t_beg"`  // 任务有效开始时间
	T_end  int64  `json:"t_end"`  // 任务有效结束时间

}

// Location 工人位置信息对象
type Location struct {
	Wid   string `json:"wid"`     // 工人id
	EpkXi string `json:"message"` // 工人加密的位置坐标信息
	Ti    int64  `json:"ti"`      // 工人位置的有效时间
	State string `json:"state"`   // 工人状态
}

// NewTask 新建任务信息对象
func NewTask(rid string, tid string, reward string, t_beg int64, t_end int64) *Task {
	task := &Task{
		Rid:    rid,
		Tid:    tid,
		Reward: reward,
		T_beg:  t_beg,
		T_end:  t_end,
	}
	return task
}

// InitContract 初始化合约SDK
func (f *TaskContract) InitContract() protogo.Response {
	return sdk.Success([]byte("Init contract success"))
}

// UpgradeContract 更新合约SDK
func (f *TaskContract) UpgradeContract() protogo.Response {
	return sdk.Success([]byte("Upgrade contract success"))
}

// InvokeContract 调用合约接口链接SDK
func (f *TaskContract) InvokeContract(method string) protogo.Response {
	switch method {
	case "UploadTask":
		return f.UploadTask()
	case "QueryFreeWorkerList":
		return f.QueryFreeWorkerList()
	case "QueryWorkerList":
		return f.QueryWorkerList()
	case "UpdateWorkerList":
		return f.UpdateWorkerList()
	default:
		return sdk.Error("invalid method")

	}
}

func (f *TaskContract) UploadTask() protogo.Response {
	params := sdk.Instance.GetArgs()

	// 获取参数
	rid := string(params["rid"])
	tid := string(params["tid"])
	reward := string(params["reward"])
	t_begstr := string(params["t_beg"])
	t_endstr := string(params["t_end"])
	t_beg, err := strconv.Atoi(t_begstr)
	if err != nil {
		msg := "t_beg is [" + t_begstr + "] not int"
		sdk.Instance.Errorf(msg)
		return sdk.Error(msg)
	}
	t_end, err := strconv.Atoi(t_endstr)
	if err != nil {
		msg := "t_end is [" + t_endstr + "] not int"
		sdk.Instance.Errorf(msg)
		return sdk.Error(msg)
	}

	// 构建结构体
	task := NewTask(rid, tid, reward, int64(t_beg), int64(t_end))

	// 序列化
	taskBytes, err := json.Marshal(task)
	if err != nil {
		return sdk.Error(fmt.Sprintf("marshal task failed, err: %s", err))
	}

	// 发送事件
	sdk.Instance.EmitEvent("UploadTask", []string{task.Rid, task.Tid, task.Reward, t_begstr, t_begstr})

	// 存储数据
	err = sdk.Instance.PutStateByte("task_bytes", task.Rid+task.Tid, taskBytes)
	if err != nil {
		return sdk.Error("fail to save task bytes")
	}

	// 记录日志
	sdk.Instance.Infof("[save] rid=" + task.Rid)
	sdk.Instance.Infof("[save] tid=" + task.Tid)
	sdk.Instance.Infof("[save] reward" + task.Reward)
	sdk.Instance.Infof("[save] t_beg" + t_begstr)
	sdk.Instance.Infof("[save] t_end=" + t_endstr)

	// 生成空闲工人集合
	// 查询工人集合
	freeworkerList := ""
	result, err := sdk.Instance.GetStateFromKey("workerList")
	if err != nil {
		return sdk.Error("failed to call get_state")
	}
	// 查询空闲的工人
	arr := strings.Fields(result)
	for i := 0; i < len(arr); i++ {
		crossContractArgs1 := make(map[string][]byte)
		crossContractArgs1["wid"] = []byte(arr[i])
		res := sdk.Instance.CallContract("LocationContract", "QueryLocation", crossContractArgs1)

		// 反序列化
		var location Location
		r := res.Payload
		if err := json.Unmarshal(r, &location); err != nil {
			return sdk.Error(fmt.Sprintf("unmarshal location failed, err: %s", err))
		}
		if location.State == "free" {
			freeworkerList += location.Wid
		}
	}
	// 更新空闲工人集合
	// 更新集合
	sdk.Instance.EmitEvent("UpdatefreeworkerList", []string{freeworkerList})
	err = sdk.Instance.PutStateFromKey("freeworkerList"+task.Rid+task.Tid, freeworkerList)
	if err != nil {
		return sdk.Error("fail to update freeworkerList")
	}
	// 记录日志
	sdk.Instance.Infof("[update] freeworkerList=" + freeworkerList)

	// 返回结果
	return sdk.Success([]byte(task.Rid + task.Tid + task.Reward + t_begstr + t_endstr))

}

func (f *TaskContract) QueryFreeWorkerList() protogo.Response {
	// 获取参数
	rid := string(sdk.Instance.GetArgs()["rid"])
	tid := string(sdk.Instance.GetArgs()["tid"])

	// 查询结果
	result, err := sdk.Instance.GetStateFromKey("freeworkerList" + rid + tid)
	if err != nil {
		return sdk.Error("failed to call get_state")
	}

	// 记录日志
	sdk.Instance.Infof("[query] freeworkerList=" + result)

	// 返回结果
	return sdk.Success([]byte(result))
}

func (f *TaskContract) QueryWorkerList() protogo.Response {
	// 查询集合
	workerList, err := sdk.Instance.GetStateFromKey("workerList")
	if err != nil {
		return sdk.Error("failed to call get_state")
	}

	// 记录日志
	sdk.Instance.Infof("[query] workerList=" + workerList)

	return sdk.Success([]byte(workerList))
}

func (f *TaskContract) UpdateWorkerList() protogo.Response {
	// 获取参数
	workerList := string(sdk.Instance.GetArgs()["workerList"])

	// 更新集合
	err := sdk.Instance.PutStateFromKey("workerList", workerList)
	if err != nil {
		return sdk.Error("fail to update workerList")
	}

	// 记录日志
	sdk.Instance.Infof("[update] workerList=" + workerList)

	return sdk.Success([]byte(workerList))

}

func main() {
	err := sandbox.Start(new(TaskContract))
	if err != nil {
		log.Fatal(err)
	}
}
