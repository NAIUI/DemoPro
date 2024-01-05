/*
Copyright (C) BABEC. All rights reserved.
Copyright (C) THL A29 Limited, a Tencent company. All rights reserved.

SPDX-License-Identifier: Apache-2.0
*/

package sandbox

import (
	"os"
	"strconv"
	"time"
)

const (
	dialTimeout        = 10 * time.Second
	maxRecvMessageSize = 20 * 1024 * 1024 // 20 MiB
	maxSendMessageSize = 20 * 1024 * 1024 // 20 MiB
	runtimeSockFile    = "/mount/runtime-sock/runtime.sock"
)

var config *Conf

type PRCProtocolType int

const (
	UDS PRCProtocolType = iota
	TCP
)

type Conf struct {
	ProcessName          string
	ContractName         string
	LogLevel             string
	ContractEngineClient *ContractEngineClientConf
	RuntimeClient        *RuntimeClientConf
}

type RuntimeClientConf struct {
	RuntimeRPCProtocolType PRCProtocolType
	RuntimeHost            string
	RuntimePort            string
	RuntimeUDSSockPath     string
	MaxSendMsgSize         int
	MaxRecvMsgSize         int
}

type ContractEngineClientConf struct {
	EngineUDSSockPath string
	MaxSendMsgSize    int
	MaxRecvMsgSize    int
}

func initConfig() error {
	/*
		Args:
		UDSSockPath
		ProcessName
		ContractName
		ContractVersion
		LogLevel
		TCPPort
		Host
	*/

	config = &Conf{
		ProcessName:  os.Args[1],
		ContractName: os.Args[2],
		LogLevel:     os.Args[4],
		ContractEngineClient: &ContractEngineClientConf{
			EngineUDSSockPath: os.Args[0],
			MaxSendMsgSize:    maxSendMessageSize,
			MaxRecvMsgSize:    maxRecvMessageSize,
		},
		RuntimeClient: &RuntimeClientConf{
			MaxSendMsgSize: maxSendMessageSize,
			MaxRecvMsgSize: maxRecvMessageSize,
		},
	}

	port, err := strconv.Atoi(os.Args[5])
	if err != nil {
		return err
	}

	if isTCP(port) {
		config.RuntimeClient.RuntimeRPCProtocolType = UDS
		config.RuntimeClient.RuntimeUDSSockPath = runtimeSockFile
		return nil
	}

	config.RuntimeClient.RuntimeRPCProtocolType = TCP
	config.RuntimeClient.RuntimeHost = os.Args[6]
	config.RuntimeClient.RuntimePort = strconv.Itoa(port)
	return nil
}

func isTCP(port int) bool {
	return port == 0
}
