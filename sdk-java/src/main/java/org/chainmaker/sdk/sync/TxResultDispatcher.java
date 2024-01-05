package org.chainmaker.sdk.sync;

import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.stub.StreamObserver;
import org.chainmaker.pb.common.ChainmakerBlock;
import org.chainmaker.pb.common.ChainmakerTransaction;
import org.chainmaker.pb.common.ResultOuterClass;
import org.chainmaker.sdk.ChainClient;

import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;

public class TxResultDispatcher {

    // block location of subscription start
    private long nextBlockNum;

    private Status status;

    // thread running subscription operation
    private final Thread thread;

    // chain configuration
    private final ChainClient chainClient;

    //
    private final ConcurrentHashMap<String, Result> result;


    static class Result {
        ChainmakerTransaction.Transaction tx;
        final Thread t;

        public Result() {
            this.t = new Thread(LockSupport::park);
        }
    }


    // init
    public TxResultDispatcher(ChainClient chainClient) {
        this.thread = new Thread(this::autoSubscribe);
        this.nextBlockNum = -1;
        this.result = new ConcurrentHashMap<>();
        this.status = Status.START;
        this.chainClient = chainClient;
    }

    public void stop () {
        this.status = Status.STOP;
        this.thread.interrupt();
    }

    public void register(String txId) {
        this.result.put(txId, new Result());
    }

    public void unregister(String txId) {
        this.result.remove(txId);
    }

    /**
     * 根据交易id获取交易
     * @param txId 交易id
     * @param timeout 超时时间
     * @return ChainmakerTransaction.Transaction
     */
    public ChainmakerTransaction.Transaction  getResult(String txId, long timeout) {
        try {
            result.get(txId).t.start();
            synchronized (result.get(txId).t) {
                result.get(txId).t.wait(timeout);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result.get(txId).tx;
    }

    // 启动线程
    public  void start()  {
        new Thread(()->{
            for (;;) {
                thread.start();
                try {
                    synchronized(thread) {
                        this.thread.wait();
                    }
                    if (this.status == Status.STOP) {
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
                try {
                    Thread.sleep(Calendar.SECOND);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
        }).start();
    }


    /**
     * 订阅
     */
    public void autoSubscribe() {
        StreamObserver<ResultOuterClass.SubscribeResult> responseObserver = new StreamObserver<ResultOuterClass.SubscribeResult>() {
            @Override
            public void onNext(ResultOuterClass.SubscribeResult value) {
                ChainmakerBlock.BlockInfo blockInfo;
                try {
                    blockInfo = ChainmakerBlock.BlockInfo.parseFrom(value.getData());
                } catch (InvalidProtocolBufferException e) {
                    throw new RuntimeException(e);
                }
                blockInfo.getBlock().getTxsList().forEach(tx -> {
                    String txId = tx.getPayload().getTxId();
                    if (result.containsKey(txId)) {
                        result.get(txId).tx = tx;
                        synchronized (result.get(txId).t) {
                            result.get(txId).t.notify();
                        }
                    }
                });
                nextBlockNum = blockInfo.getBlock().getHeader().getBlockHeight() + 1;
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
                synchronized (thread) {
                    thread.notify();
                }
            }

            @Override
            public void onCompleted() {
                synchronized (thread) {
                    thread.notify();
                }
            }
        };

        try {
            chainClient.subscribeBlock(nextBlockNum, -1, true, false, responseObserver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LockSupport.park();
    }

    enum Status {
        START(0),

        STOP(1);

        private final Integer type;

        Status(int type) {
            this.type = type;
        }

        public int type() {
            return this.type;
        }
    }
}
