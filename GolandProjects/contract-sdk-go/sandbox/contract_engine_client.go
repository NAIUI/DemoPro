/*
Copyright (C) BABEC. All rights reserved.
Copyright (C) THL A29 Limited, a Tencent company. All rights reserved.

SPDX-License-Identifier: Apache-2.0
*/

package sandbox

import (
	"chainmaker.org/chainmaker/contract-sdk-go/v2/pb/protogo"
	"errors"
	"fmt"
	"go.uber.org/zap"
	"io"
	"sync"
	"time"
)

type state string

const (
	created state = "created"
	ready   state = "ready"
)

type ContractEngineClient struct {
	logger          *zap.SugaredLogger
	serialLock      sync.Mutex
	rpcClient       protogo.DockerVMRpc_DockerVMCommunicateClient
	state           state
	putTxReqMsgFunc func(msg *protogo.DockerVMMessage, signalNotify func(signal *protogo.DockerVMMessage))
	txFinishMsgChan chan *protogo.DockerVMMessage

	processName  string
	contractName string
}

func newContractEngineClient(rpcClient protogo.DockerVMRpc_DockerVMCommunicateClient, processName, contractName string, logger *zap.SugaredLogger) *ContractEngineClient {
	return &ContractEngineClient{
		logger:          logger,
		serialLock:      sync.Mutex{},
		rpcClient:       rpcClient,
		txFinishMsgChan: make(chan *protogo.DockerVMMessage, 200),
		state:           created,
		processName:     processName,
		contractName:    contractName,
	}
}

func (c *ContractEngineClient) Start() error {
	c.logger.Info("start contract engine client")
	defer func() {
		err := c.rpcClient.CloseSend()
		if err != nil {
			return
		}
	}()

	// chat with engine
	if err := c.chatWithEngine(); err != nil {
		return err
	}

	errCh := make(chan error, 1)

	// listen incoming message
	go func() {
		if err := c.listenTxRequest(); err != nil {
			errCh <- err
		}
	}()

	// send signal
	go func() {
		if err := c.sendTxFinishMsg(); err != nil {
			errCh <- err
		}
	}()

	return <-errCh
}

func (c *ContractEngineClient) chatWithEngine() error {
	c.logger.Debugf("sandbox - chat with manager")

	// Send the register
	if err := c.sendMessage(
		&protogo.DockerVMMessage{
			Type: protogo.DockerVMType_REGISTER,
			CrossContext: &protogo.CrossContext{
				ProcessName: c.processName,
			},
		},
	); err != nil {
		return fmt.Errorf("error sending chaincode REGISTER: %s", err)
	}
	c.state = ready

	return nil
}

// listenTxRequest listen request from contract engine
func (c *ContractEngineClient) listenTxRequest() error {
	c.logger.Infof("start receiving engine server message")
	// holds return values from gRPC Recv below
	// recv message
	for {
		msg, err := c.rpcClient.Recv()
		switch {
		case err == io.EOF:
			err := fmt.Errorf("receive end: %s", err)
			return err
		case err != nil:
			err := fmt.Errorf("receive failed: %s", err)
			return err
		case msg == nil:
			err := errors.New("received nil message, ending chaincode stream")
			return err
		default:
			c.logger.Debugf("[%s] sandbox receive txRequest from contract engine, msgType [%s]", msg.TxId, msg.Type)
			EnterNextStep(msg, protogo.StepType_SANDBOX_GRPC_RECEIVE_TX_REQUEST, "")
			c.putTxReqMsgFunc(msg, c.PutFinishMsg)
		}
	}
}

// RegisterTxRequestPutFunc register put func to send txRequest to txHandler with a callback fun that returns a finish signal
func (c *ContractEngineClient) RegisterTxRequestPutFunc(txRequestPutFunc func(msg *protogo.DockerVMMessage,
	txFinishMsgNotifyFunc func(signal *protogo.DockerVMMessage))) {
	c.putTxReqMsgFunc = txRequestPutFunc
}

func (c *ContractEngineClient) PutFinishMsg(msg *protogo.DockerVMMessage) {
	c.logger.Debugf("put finisl signal to signal queue, txId [%s], msgType [%s], chan len: [%d]", msg.TxId,
		msg.Type, len(c.txFinishMsgChan))
	c.txFinishMsgChan <- msg
}

// sendTxFinishMsg send message to contract engine
func (c *ContractEngineClient) sendTxFinishMsg() error {
	c.logger.Info("start sending signal to contract engine server")
	for msg := range c.txFinishMsgChan {
		c.logger.Debugf("get msg from signal queue, txId: [%s], msgType: [%s]", msg.TxId, msg.Type)

		timeByte, _ := time.Now().MarshalBinary()
		msg.Response = &protogo.TxResponse{
			Result: timeByte,
		}

		if err := c.sendMessage(msg); err != nil {
			c.logger.Errorf("send finish message to engine failed, err:%s", err)
			return err
		}
	}

	return nil
}

// sendMessage Send on the gRPC client.
func (c *ContractEngineClient) sendMessage(msg *protogo.DockerVMMessage) error {
	c.serialLock.Lock()
	defer c.serialLock.Unlock()

	c.logger.Debugf("[%s] sandbox send signal to contract engine, msg: [%+v]", msg.TxId, msg)
	return c.rpcClient.Send(msg)
}
