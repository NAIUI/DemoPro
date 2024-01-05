package org.chainmaker.pb.api;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * rpcNnode is the server API for
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.25.0)",
    comments = "Source: api/rpc_node.proto")
public final class RpcNodeGrpc {

  private RpcNodeGrpc() {}

  public static final String SERVICE_NAME = "api.RpcNode";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.chainmaker.pb.common.Request.TxRequest,
      org.chainmaker.pb.common.ResultOuterClass.TxResponse> getSendRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendRequest",
      requestType = org.chainmaker.pb.common.Request.TxRequest.class,
      responseType = org.chainmaker.pb.common.ResultOuterClass.TxResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.chainmaker.pb.common.Request.TxRequest,
      org.chainmaker.pb.common.ResultOuterClass.TxResponse> getSendRequestMethod() {
    io.grpc.MethodDescriptor<org.chainmaker.pb.common.Request.TxRequest, org.chainmaker.pb.common.ResultOuterClass.TxResponse> getSendRequestMethod;
    if ((getSendRequestMethod = RpcNodeGrpc.getSendRequestMethod) == null) {
      synchronized (RpcNodeGrpc.class) {
        if ((getSendRequestMethod = RpcNodeGrpc.getSendRequestMethod) == null) {
          RpcNodeGrpc.getSendRequestMethod = getSendRequestMethod =
              io.grpc.MethodDescriptor.<org.chainmaker.pb.common.Request.TxRequest, org.chainmaker.pb.common.ResultOuterClass.TxResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.common.Request.TxRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.common.ResultOuterClass.TxResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcNodeMethodDescriptorSupplier("SendRequest"))
              .build();
        }
      }
    }
    return getSendRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.chainmaker.pb.common.Request.TxRequest,
      org.chainmaker.pb.common.ResultOuterClass.SubscribeResult> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Subscribe",
      requestType = org.chainmaker.pb.common.Request.TxRequest.class,
      responseType = org.chainmaker.pb.common.ResultOuterClass.SubscribeResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.chainmaker.pb.common.Request.TxRequest,
      org.chainmaker.pb.common.ResultOuterClass.SubscribeResult> getSubscribeMethod() {
    io.grpc.MethodDescriptor<org.chainmaker.pb.common.Request.TxRequest, org.chainmaker.pb.common.ResultOuterClass.SubscribeResult> getSubscribeMethod;
    if ((getSubscribeMethod = RpcNodeGrpc.getSubscribeMethod) == null) {
      synchronized (RpcNodeGrpc.class) {
        if ((getSubscribeMethod = RpcNodeGrpc.getSubscribeMethod) == null) {
          RpcNodeGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<org.chainmaker.pb.common.Request.TxRequest, org.chainmaker.pb.common.ResultOuterClass.SubscribeResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.common.Request.TxRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.common.ResultOuterClass.SubscribeResult.getDefaultInstance()))
              .setSchemaDescriptor(new RpcNodeMethodDescriptorSupplier("Subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.chainmaker.pb.common.Request.RawTxRequest,
      org.chainmaker.pb.common.ResultOuterClass.SubscribeResult> getSubscribeWSMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubscribeWS",
      requestType = org.chainmaker.pb.common.Request.RawTxRequest.class,
      responseType = org.chainmaker.pb.common.ResultOuterClass.SubscribeResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.chainmaker.pb.common.Request.RawTxRequest,
      org.chainmaker.pb.common.ResultOuterClass.SubscribeResult> getSubscribeWSMethod() {
    io.grpc.MethodDescriptor<org.chainmaker.pb.common.Request.RawTxRequest, org.chainmaker.pb.common.ResultOuterClass.SubscribeResult> getSubscribeWSMethod;
    if ((getSubscribeWSMethod = RpcNodeGrpc.getSubscribeWSMethod) == null) {
      synchronized (RpcNodeGrpc.class) {
        if ((getSubscribeWSMethod = RpcNodeGrpc.getSubscribeWSMethod) == null) {
          RpcNodeGrpc.getSubscribeWSMethod = getSubscribeWSMethod =
              io.grpc.MethodDescriptor.<org.chainmaker.pb.common.Request.RawTxRequest, org.chainmaker.pb.common.ResultOuterClass.SubscribeResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubscribeWS"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.common.Request.RawTxRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.common.ResultOuterClass.SubscribeResult.getDefaultInstance()))
              .setSchemaDescriptor(new RpcNodeMethodDescriptorSupplier("SubscribeWS"))
              .build();
        }
      }
    }
    return getSubscribeWSMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.chainmaker.pb.config.LocalConfig.DebugConfigRequest,
      org.chainmaker.pb.config.LocalConfig.DebugConfigResponse> getUpdateDebugConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDebugConfig",
      requestType = org.chainmaker.pb.config.LocalConfig.DebugConfigRequest.class,
      responseType = org.chainmaker.pb.config.LocalConfig.DebugConfigResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.chainmaker.pb.config.LocalConfig.DebugConfigRequest,
      org.chainmaker.pb.config.LocalConfig.DebugConfigResponse> getUpdateDebugConfigMethod() {
    io.grpc.MethodDescriptor<org.chainmaker.pb.config.LocalConfig.DebugConfigRequest, org.chainmaker.pb.config.LocalConfig.DebugConfigResponse> getUpdateDebugConfigMethod;
    if ((getUpdateDebugConfigMethod = RpcNodeGrpc.getUpdateDebugConfigMethod) == null) {
      synchronized (RpcNodeGrpc.class) {
        if ((getUpdateDebugConfigMethod = RpcNodeGrpc.getUpdateDebugConfigMethod) == null) {
          RpcNodeGrpc.getUpdateDebugConfigMethod = getUpdateDebugConfigMethod =
              io.grpc.MethodDescriptor.<org.chainmaker.pb.config.LocalConfig.DebugConfigRequest, org.chainmaker.pb.config.LocalConfig.DebugConfigResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDebugConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.config.LocalConfig.DebugConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.config.LocalConfig.DebugConfigResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcNodeMethodDescriptorSupplier("UpdateDebugConfig"))
              .build();
        }
      }
    }
    return getUpdateDebugConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.chainmaker.pb.config.LogConfig.LogLevelsRequest,
      org.chainmaker.pb.config.LogConfig.LogLevelsResponse> getRefreshLogLevelsConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RefreshLogLevelsConfig",
      requestType = org.chainmaker.pb.config.LogConfig.LogLevelsRequest.class,
      responseType = org.chainmaker.pb.config.LogConfig.LogLevelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.chainmaker.pb.config.LogConfig.LogLevelsRequest,
      org.chainmaker.pb.config.LogConfig.LogLevelsResponse> getRefreshLogLevelsConfigMethod() {
    io.grpc.MethodDescriptor<org.chainmaker.pb.config.LogConfig.LogLevelsRequest, org.chainmaker.pb.config.LogConfig.LogLevelsResponse> getRefreshLogLevelsConfigMethod;
    if ((getRefreshLogLevelsConfigMethod = RpcNodeGrpc.getRefreshLogLevelsConfigMethod) == null) {
      synchronized (RpcNodeGrpc.class) {
        if ((getRefreshLogLevelsConfigMethod = RpcNodeGrpc.getRefreshLogLevelsConfigMethod) == null) {
          RpcNodeGrpc.getRefreshLogLevelsConfigMethod = getRefreshLogLevelsConfigMethod =
              io.grpc.MethodDescriptor.<org.chainmaker.pb.config.LogConfig.LogLevelsRequest, org.chainmaker.pb.config.LogConfig.LogLevelsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RefreshLogLevelsConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.config.LogConfig.LogLevelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.config.LogConfig.LogLevelsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcNodeMethodDescriptorSupplier("RefreshLogLevelsConfig"))
              .build();
        }
      }
    }
    return getRefreshLogLevelsConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionRequest,
      org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionResponse> getGetChainMakerVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetChainMakerVersion",
      requestType = org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionRequest.class,
      responseType = org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionRequest,
      org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionResponse> getGetChainMakerVersionMethod() {
    io.grpc.MethodDescriptor<org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionRequest, org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionResponse> getGetChainMakerVersionMethod;
    if ((getGetChainMakerVersionMethod = RpcNodeGrpc.getGetChainMakerVersionMethod) == null) {
      synchronized (RpcNodeGrpc.class) {
        if ((getGetChainMakerVersionMethod = RpcNodeGrpc.getGetChainMakerVersionMethod) == null) {
          RpcNodeGrpc.getGetChainMakerVersionMethod = getGetChainMakerVersionMethod =
              io.grpc.MethodDescriptor.<org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionRequest, org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetChainMakerVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcNodeMethodDescriptorSupplier("GetChainMakerVersion"))
              .build();
        }
      }
    }
    return getGetChainMakerVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigRequest,
      org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigResponse> getCheckNewBlockChainConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckNewBlockChainConfig",
      requestType = org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigRequest.class,
      responseType = org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigRequest,
      org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigResponse> getCheckNewBlockChainConfigMethod() {
    io.grpc.MethodDescriptor<org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigRequest, org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigResponse> getCheckNewBlockChainConfigMethod;
    if ((getCheckNewBlockChainConfigMethod = RpcNodeGrpc.getCheckNewBlockChainConfigMethod) == null) {
      synchronized (RpcNodeGrpc.class) {
        if ((getCheckNewBlockChainConfigMethod = RpcNodeGrpc.getCheckNewBlockChainConfigMethod) == null) {
          RpcNodeGrpc.getCheckNewBlockChainConfigMethod = getCheckNewBlockChainConfigMethod =
              io.grpc.MethodDescriptor.<org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigRequest, org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckNewBlockChainConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcNodeMethodDescriptorSupplier("CheckNewBlockChainConfig"))
              .build();
        }
      }
    }
    return getCheckNewBlockChainConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.chainmaker.pb.txpool.TransactionPool.GetPoolStatusRequest,
      org.chainmaker.pb.txpool.TransactionPool.TxPoolStatus> getGetPoolStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPoolStatus",
      requestType = org.chainmaker.pb.txpool.TransactionPool.GetPoolStatusRequest.class,
      responseType = org.chainmaker.pb.txpool.TransactionPool.TxPoolStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.chainmaker.pb.txpool.TransactionPool.GetPoolStatusRequest,
      org.chainmaker.pb.txpool.TransactionPool.TxPoolStatus> getGetPoolStatusMethod() {
    io.grpc.MethodDescriptor<org.chainmaker.pb.txpool.TransactionPool.GetPoolStatusRequest, org.chainmaker.pb.txpool.TransactionPool.TxPoolStatus> getGetPoolStatusMethod;
    if ((getGetPoolStatusMethod = RpcNodeGrpc.getGetPoolStatusMethod) == null) {
      synchronized (RpcNodeGrpc.class) {
        if ((getGetPoolStatusMethod = RpcNodeGrpc.getGetPoolStatusMethod) == null) {
          RpcNodeGrpc.getGetPoolStatusMethod = getGetPoolStatusMethod =
              io.grpc.MethodDescriptor.<org.chainmaker.pb.txpool.TransactionPool.GetPoolStatusRequest, org.chainmaker.pb.txpool.TransactionPool.TxPoolStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPoolStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.txpool.TransactionPool.GetPoolStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.txpool.TransactionPool.TxPoolStatus.getDefaultInstance()))
              .setSchemaDescriptor(new RpcNodeMethodDescriptorSupplier("GetPoolStatus"))
              .build();
        }
      }
    }
    return getGetPoolStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageRequest,
      org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageResponse> getGetTxIdsByTypeAndStageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTxIdsByTypeAndStage",
      requestType = org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageRequest.class,
      responseType = org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageRequest,
      org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageResponse> getGetTxIdsByTypeAndStageMethod() {
    io.grpc.MethodDescriptor<org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageRequest, org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageResponse> getGetTxIdsByTypeAndStageMethod;
    if ((getGetTxIdsByTypeAndStageMethod = RpcNodeGrpc.getGetTxIdsByTypeAndStageMethod) == null) {
      synchronized (RpcNodeGrpc.class) {
        if ((getGetTxIdsByTypeAndStageMethod = RpcNodeGrpc.getGetTxIdsByTypeAndStageMethod) == null) {
          RpcNodeGrpc.getGetTxIdsByTypeAndStageMethod = getGetTxIdsByTypeAndStageMethod =
              io.grpc.MethodDescriptor.<org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageRequest, org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTxIdsByTypeAndStage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcNodeMethodDescriptorSupplier("GetTxIdsByTypeAndStage"))
              .build();
        }
      }
    }
    return getGetTxIdsByTypeAndStageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsRequest,
      org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsResponse> getGetTxsInPoolByTxIdsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTxsInPoolByTxIds",
      requestType = org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsRequest.class,
      responseType = org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsRequest,
      org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsResponse> getGetTxsInPoolByTxIdsMethod() {
    io.grpc.MethodDescriptor<org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsRequest, org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsResponse> getGetTxsInPoolByTxIdsMethod;
    if ((getGetTxsInPoolByTxIdsMethod = RpcNodeGrpc.getGetTxsInPoolByTxIdsMethod) == null) {
      synchronized (RpcNodeGrpc.class) {
        if ((getGetTxsInPoolByTxIdsMethod = RpcNodeGrpc.getGetTxsInPoolByTxIdsMethod) == null) {
          RpcNodeGrpc.getGetTxsInPoolByTxIdsMethod = getGetTxsInPoolByTxIdsMethod =
              io.grpc.MethodDescriptor.<org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsRequest, org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTxsInPoolByTxIds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcNodeMethodDescriptorSupplier("GetTxsInPoolByTxIds"))
              .build();
        }
      }
    }
    return getGetTxsInPoolByTxIdsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RpcNodeStub newStub(io.grpc.Channel channel) {
    return new RpcNodeStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RpcNodeBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RpcNodeBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RpcNodeFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RpcNodeFutureStub(channel);
  }

  /**
   * <pre>
   * rpcNnode is the server API for
   * </pre>
   */
  public static abstract class RpcNodeImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * processing transaction message requests
     * </pre>
     */
    public void sendRequest(org.chainmaker.pb.common.Request.TxRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.common.ResultOuterClass.TxResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendRequestMethod(), responseObserver);
    }

    /**
     * <pre>
     * processing requests for message subscription
     * </pre>
     */
    public void subscribe(org.chainmaker.pb.common.Request.TxRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.common.ResultOuterClass.SubscribeResult> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }

    /**
     * <pre>
     * processing requests for message subscription by websocket
     * </pre>
     */
    public void subscribeWS(org.chainmaker.pb.common.Request.RawTxRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.common.ResultOuterClass.SubscribeResult> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeWSMethod(), responseObserver);
    }

    /**
     * <pre>
     * update debug status (development debugging)
     * </pre>
     */
    public void updateDebugConfig(org.chainmaker.pb.config.LocalConfig.DebugConfigRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.config.LocalConfig.DebugConfigResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateDebugConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * refreshLogLevelsConfig
     * </pre>
     */
    public void refreshLogLevelsConfig(org.chainmaker.pb.config.LogConfig.LogLevelsRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.config.LogConfig.LogLevelsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRefreshLogLevelsConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * get chainmaker version
     * </pre>
     */
    public void getChainMakerVersion(org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetChainMakerVersionMethod(), responseObserver);
    }

    /**
     * <pre>
     * check chain configuration and load new chain dynamically
     * </pre>
     */
    public void checkNewBlockChainConfig(org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckNewBlockChainConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetPoolStatus Returns the max size of config transaction pool and common transaction pool,
     * the num of config transaction in queue and pendingCache,
     * and the the num of common transaction in queue and pendingCache.
     * </pre>
     */
    public void getPoolStatus(org.chainmaker.pb.txpool.TransactionPool.GetPoolStatusRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.txpool.TransactionPool.TxPoolStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPoolStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetTxIdsByTypeAndStage Returns config or common txIds in different stage.
     * TxType may be TxType_CONFIG_TX, TxType_COMMON_TX, (TxType_CONFIG_TX|TxType_COMMON_TX)
     * TxStage may be TxStage_IN_QUEUE, TxStage_IN_PENDING, (TxStage_IN_QUEUE|TxStage_IN_PENDING)
     * </pre>
     */
    public void getTxIdsByTypeAndStage(org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTxIdsByTypeAndStageMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetTxsInPoolByTxIds Retrieve the transactions by the txIds from the txPool,
     * return transactions in the txPool and txIds not in txPool.
     * default query upper limit is 1w transaction, and error is returned if the limit is exceeded.
     * </pre>
     */
    public void getTxsInPoolByTxIds(org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTxsInPoolByTxIdsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendRequestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.chainmaker.pb.common.Request.TxRequest,
                org.chainmaker.pb.common.ResultOuterClass.TxResponse>(
                  this, METHODID_SEND_REQUEST)))
          .addMethod(
            getSubscribeMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.chainmaker.pb.common.Request.TxRequest,
                org.chainmaker.pb.common.ResultOuterClass.SubscribeResult>(
                  this, METHODID_SUBSCRIBE)))
          .addMethod(
            getSubscribeWSMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.chainmaker.pb.common.Request.RawTxRequest,
                org.chainmaker.pb.common.ResultOuterClass.SubscribeResult>(
                  this, METHODID_SUBSCRIBE_WS)))
          .addMethod(
            getUpdateDebugConfigMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.chainmaker.pb.config.LocalConfig.DebugConfigRequest,
                org.chainmaker.pb.config.LocalConfig.DebugConfigResponse>(
                  this, METHODID_UPDATE_DEBUG_CONFIG)))
          .addMethod(
            getRefreshLogLevelsConfigMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.chainmaker.pb.config.LogConfig.LogLevelsRequest,
                org.chainmaker.pb.config.LogConfig.LogLevelsResponse>(
                  this, METHODID_REFRESH_LOG_LEVELS_CONFIG)))
          .addMethod(
            getGetChainMakerVersionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionRequest,
                org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionResponse>(
                  this, METHODID_GET_CHAIN_MAKER_VERSION)))
          .addMethod(
            getCheckNewBlockChainConfigMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigRequest,
                org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigResponse>(
                  this, METHODID_CHECK_NEW_BLOCK_CHAIN_CONFIG)))
          .addMethod(
            getGetPoolStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.chainmaker.pb.txpool.TransactionPool.GetPoolStatusRequest,
                org.chainmaker.pb.txpool.TransactionPool.TxPoolStatus>(
                  this, METHODID_GET_POOL_STATUS)))
          .addMethod(
            getGetTxIdsByTypeAndStageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageRequest,
                org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageResponse>(
                  this, METHODID_GET_TX_IDS_BY_TYPE_AND_STAGE)))
          .addMethod(
            getGetTxsInPoolByTxIdsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsRequest,
                org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsResponse>(
                  this, METHODID_GET_TXS_IN_POOL_BY_TX_IDS)))
          .build();
    }
  }

  /**
   * <pre>
   * rpcNnode is the server API for
   * </pre>
   */
  public static final class RpcNodeStub extends io.grpc.stub.AbstractStub<RpcNodeStub> {
    private RpcNodeStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RpcNodeStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RpcNodeStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RpcNodeStub(channel, callOptions);
    }

    /**
     * <pre>
     * processing transaction message requests
     * </pre>
     */
    public void sendRequest(org.chainmaker.pb.common.Request.TxRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.common.ResultOuterClass.TxResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * processing requests for message subscription
     * </pre>
     */
    public void subscribe(org.chainmaker.pb.common.Request.TxRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.common.ResultOuterClass.SubscribeResult> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * processing requests for message subscription by websocket
     * </pre>
     */
    public void subscribeWS(org.chainmaker.pb.common.Request.RawTxRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.common.ResultOuterClass.SubscribeResult> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSubscribeWSMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * update debug status (development debugging)
     * </pre>
     */
    public void updateDebugConfig(org.chainmaker.pb.config.LocalConfig.DebugConfigRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.config.LocalConfig.DebugConfigResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateDebugConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * refreshLogLevelsConfig
     * </pre>
     */
    public void refreshLogLevelsConfig(org.chainmaker.pb.config.LogConfig.LogLevelsRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.config.LogConfig.LogLevelsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRefreshLogLevelsConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * get chainmaker version
     * </pre>
     */
    public void getChainMakerVersion(org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetChainMakerVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * check chain configuration and load new chain dynamically
     * </pre>
     */
    public void checkNewBlockChainConfig(org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckNewBlockChainConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetPoolStatus Returns the max size of config transaction pool and common transaction pool,
     * the num of config transaction in queue and pendingCache,
     * and the the num of common transaction in queue and pendingCache.
     * </pre>
     */
    public void getPoolStatus(org.chainmaker.pb.txpool.TransactionPool.GetPoolStatusRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.txpool.TransactionPool.TxPoolStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPoolStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetTxIdsByTypeAndStage Returns config or common txIds in different stage.
     * TxType may be TxType_CONFIG_TX, TxType_COMMON_TX, (TxType_CONFIG_TX|TxType_COMMON_TX)
     * TxStage may be TxStage_IN_QUEUE, TxStage_IN_PENDING, (TxStage_IN_QUEUE|TxStage_IN_PENDING)
     * </pre>
     */
    public void getTxIdsByTypeAndStage(org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTxIdsByTypeAndStageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetTxsInPoolByTxIds Retrieve the transactions by the txIds from the txPool,
     * return transactions in the txPool and txIds not in txPool.
     * default query upper limit is 1w transaction, and error is returned if the limit is exceeded.
     * </pre>
     */
    public void getTxsInPoolByTxIds(org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsRequest request,
        io.grpc.stub.StreamObserver<org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTxsInPoolByTxIdsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * rpcNnode is the server API for
   * </pre>
   */
  public static final class RpcNodeBlockingStub extends io.grpc.stub.AbstractStub<RpcNodeBlockingStub> {
    private RpcNodeBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RpcNodeBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RpcNodeBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RpcNodeBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * processing transaction message requests
     * </pre>
     */
    public org.chainmaker.pb.common.ResultOuterClass.TxResponse sendRequest(org.chainmaker.pb.common.Request.TxRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendRequestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * processing requests for message subscription
     * </pre>
     */
    public java.util.Iterator<org.chainmaker.pb.common.ResultOuterClass.SubscribeResult> subscribe(
        org.chainmaker.pb.common.Request.TxRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * processing requests for message subscription by websocket
     * </pre>
     */
    public java.util.Iterator<org.chainmaker.pb.common.ResultOuterClass.SubscribeResult> subscribeWS(
        org.chainmaker.pb.common.Request.RawTxRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSubscribeWSMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * update debug status (development debugging)
     * </pre>
     */
    public org.chainmaker.pb.config.LocalConfig.DebugConfigResponse updateDebugConfig(org.chainmaker.pb.config.LocalConfig.DebugConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateDebugConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * refreshLogLevelsConfig
     * </pre>
     */
    public org.chainmaker.pb.config.LogConfig.LogLevelsResponse refreshLogLevelsConfig(org.chainmaker.pb.config.LogConfig.LogLevelsRequest request) {
      return blockingUnaryCall(
          getChannel(), getRefreshLogLevelsConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * get chainmaker version
     * </pre>
     */
    public org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionResponse getChainMakerVersion(org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetChainMakerVersionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * check chain configuration and load new chain dynamically
     * </pre>
     */
    public org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigResponse checkNewBlockChainConfig(org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckNewBlockChainConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetPoolStatus Returns the max size of config transaction pool and common transaction pool,
     * the num of config transaction in queue and pendingCache,
     * and the the num of common transaction in queue and pendingCache.
     * </pre>
     */
    public org.chainmaker.pb.txpool.TransactionPool.TxPoolStatus getPoolStatus(org.chainmaker.pb.txpool.TransactionPool.GetPoolStatusRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPoolStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetTxIdsByTypeAndStage Returns config or common txIds in different stage.
     * TxType may be TxType_CONFIG_TX, TxType_COMMON_TX, (TxType_CONFIG_TX|TxType_COMMON_TX)
     * TxStage may be TxStage_IN_QUEUE, TxStage_IN_PENDING, (TxStage_IN_QUEUE|TxStage_IN_PENDING)
     * </pre>
     */
    public org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageResponse getTxIdsByTypeAndStage(org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTxIdsByTypeAndStageMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetTxsInPoolByTxIds Retrieve the transactions by the txIds from the txPool,
     * return transactions in the txPool and txIds not in txPool.
     * default query upper limit is 1w transaction, and error is returned if the limit is exceeded.
     * </pre>
     */
    public org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsResponse getTxsInPoolByTxIds(org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTxsInPoolByTxIdsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * rpcNnode is the server API for
   * </pre>
   */
  public static final class RpcNodeFutureStub extends io.grpc.stub.AbstractStub<RpcNodeFutureStub> {
    private RpcNodeFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RpcNodeFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RpcNodeFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RpcNodeFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * processing transaction message requests
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.chainmaker.pb.common.ResultOuterClass.TxResponse> sendRequest(
        org.chainmaker.pb.common.Request.TxRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendRequestMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * update debug status (development debugging)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.chainmaker.pb.config.LocalConfig.DebugConfigResponse> updateDebugConfig(
        org.chainmaker.pb.config.LocalConfig.DebugConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateDebugConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * refreshLogLevelsConfig
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.chainmaker.pb.config.LogConfig.LogLevelsResponse> refreshLogLevelsConfig(
        org.chainmaker.pb.config.LogConfig.LogLevelsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRefreshLogLevelsConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * get chainmaker version
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionResponse> getChainMakerVersion(
        org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetChainMakerVersionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * check chain configuration and load new chain dynamically
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigResponse> checkNewBlockChainConfig(
        org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckNewBlockChainConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetPoolStatus Returns the max size of config transaction pool and common transaction pool,
     * the num of config transaction in queue and pendingCache,
     * and the the num of common transaction in queue and pendingCache.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.chainmaker.pb.txpool.TransactionPool.TxPoolStatus> getPoolStatus(
        org.chainmaker.pb.txpool.TransactionPool.GetPoolStatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPoolStatusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetTxIdsByTypeAndStage Returns config or common txIds in different stage.
     * TxType may be TxType_CONFIG_TX, TxType_COMMON_TX, (TxType_CONFIG_TX|TxType_COMMON_TX)
     * TxStage may be TxStage_IN_QUEUE, TxStage_IN_PENDING, (TxStage_IN_QUEUE|TxStage_IN_PENDING)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageResponse> getTxIdsByTypeAndStage(
        org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTxIdsByTypeAndStageMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetTxsInPoolByTxIds Retrieve the transactions by the txIds from the txPool,
     * return transactions in the txPool and txIds not in txPool.
     * default query upper limit is 1w transaction, and error is returned if the limit is exceeded.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsResponse> getTxsInPoolByTxIds(
        org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTxsInPoolByTxIdsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_REQUEST = 0;
  private static final int METHODID_SUBSCRIBE = 1;
  private static final int METHODID_SUBSCRIBE_WS = 2;
  private static final int METHODID_UPDATE_DEBUG_CONFIG = 3;
  private static final int METHODID_REFRESH_LOG_LEVELS_CONFIG = 4;
  private static final int METHODID_GET_CHAIN_MAKER_VERSION = 5;
  private static final int METHODID_CHECK_NEW_BLOCK_CHAIN_CONFIG = 6;
  private static final int METHODID_GET_POOL_STATUS = 7;
  private static final int METHODID_GET_TX_IDS_BY_TYPE_AND_STAGE = 8;
  private static final int METHODID_GET_TXS_IN_POOL_BY_TX_IDS = 9;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RpcNodeImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RpcNodeImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_REQUEST:
          serviceImpl.sendRequest((org.chainmaker.pb.common.Request.TxRequest) request,
              (io.grpc.stub.StreamObserver<org.chainmaker.pb.common.ResultOuterClass.TxResponse>) responseObserver);
          break;
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((org.chainmaker.pb.common.Request.TxRequest) request,
              (io.grpc.stub.StreamObserver<org.chainmaker.pb.common.ResultOuterClass.SubscribeResult>) responseObserver);
          break;
        case METHODID_SUBSCRIBE_WS:
          serviceImpl.subscribeWS((org.chainmaker.pb.common.Request.RawTxRequest) request,
              (io.grpc.stub.StreamObserver<org.chainmaker.pb.common.ResultOuterClass.SubscribeResult>) responseObserver);
          break;
        case METHODID_UPDATE_DEBUG_CONFIG:
          serviceImpl.updateDebugConfig((org.chainmaker.pb.config.LocalConfig.DebugConfigRequest) request,
              (io.grpc.stub.StreamObserver<org.chainmaker.pb.config.LocalConfig.DebugConfigResponse>) responseObserver);
          break;
        case METHODID_REFRESH_LOG_LEVELS_CONFIG:
          serviceImpl.refreshLogLevelsConfig((org.chainmaker.pb.config.LogConfig.LogLevelsRequest) request,
              (io.grpc.stub.StreamObserver<org.chainmaker.pb.config.LogConfig.LogLevelsResponse>) responseObserver);
          break;
        case METHODID_GET_CHAIN_MAKER_VERSION:
          serviceImpl.getChainMakerVersion((org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionRequest) request,
              (io.grpc.stub.StreamObserver<org.chainmaker.pb.config.ChainmakerServer.ChainMakerVersionResponse>) responseObserver);
          break;
        case METHODID_CHECK_NEW_BLOCK_CHAIN_CONFIG:
          serviceImpl.checkNewBlockChainConfig((org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigRequest) request,
              (io.grpc.stub.StreamObserver<org.chainmaker.pb.config.LocalConfig.CheckNewBlockChainConfigResponse>) responseObserver);
          break;
        case METHODID_GET_POOL_STATUS:
          serviceImpl.getPoolStatus((org.chainmaker.pb.txpool.TransactionPool.GetPoolStatusRequest) request,
              (io.grpc.stub.StreamObserver<org.chainmaker.pb.txpool.TransactionPool.TxPoolStatus>) responseObserver);
          break;
        case METHODID_GET_TX_IDS_BY_TYPE_AND_STAGE:
          serviceImpl.getTxIdsByTypeAndStage((org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageRequest) request,
              (io.grpc.stub.StreamObserver<org.chainmaker.pb.txpool.TransactionPool.GetTxIdsByTypeAndStageResponse>) responseObserver);
          break;
        case METHODID_GET_TXS_IN_POOL_BY_TX_IDS:
          serviceImpl.getTxsInPoolByTxIds((org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsRequest) request,
              (io.grpc.stub.StreamObserver<org.chainmaker.pb.txpool.TransactionPool.GetTxsInPoolByTxIdsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RpcNodeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RpcNodeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.chainmaker.pb.api.RpcNodeOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RpcNode");
    }
  }

  private static final class RpcNodeFileDescriptorSupplier
      extends RpcNodeBaseDescriptorSupplier {
    RpcNodeFileDescriptorSupplier() {}
  }

  private static final class RpcNodeMethodDescriptorSupplier
      extends RpcNodeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RpcNodeMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RpcNodeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RpcNodeFileDescriptorSupplier())
              .addMethod(getSendRequestMethod())
              .addMethod(getSubscribeMethod())
              .addMethod(getSubscribeWSMethod())
              .addMethod(getUpdateDebugConfigMethod())
              .addMethod(getRefreshLogLevelsConfigMethod())
              .addMethod(getGetChainMakerVersionMethod())
              .addMethod(getCheckNewBlockChainConfigMethod())
              .addMethod(getGetPoolStatusMethod())
              .addMethod(getGetTxIdsByTypeAndStageMethod())
              .addMethod(getGetTxsInPoolByTxIdsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
