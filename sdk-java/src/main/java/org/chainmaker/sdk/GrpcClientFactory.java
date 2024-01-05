package org.chainmaker.sdk;

import io.grpc.ConnectivityState;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.DestroyMode;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.chainmaker.pb.api.RpcNodeGrpc;
import org.chainmaker.pb.config.ChainmakerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class GrpcClientFactory extends BasePooledObjectFactory<RpcServiceClient> {

    private static final Logger logger = LoggerFactory.getLogger(GrpcClientFactory.class);

    private final User clientUser;
    private final int messageSize;

    //用户保存异常节点，用于当次连接时避开错误节点


    //待连接节点
    private Set<Node> readNodes;

    //维护节点host和连接数,每个节点可以建立多个连接
    private Map<String, AtomicInteger> nodeConnCountMap;
    //连接 ——>节点连接host
    private Map<RpcServiceClient, String> connNodeMap;

    //业务可用性检测时的超时时间，默认3s.
    final long rpcCallTimeout = 3000;

    //对应的连接池
    GenericObjectPool<RpcServiceClient> connPool;

    public void setPool(GenericObjectPool<RpcServiceClient> connPool) {
        this.connPool = connPool;
    }

    /**
     * @param nodes       节点信息数组
     * @param clientUser  用户信息
     * @param messageSize grpc客户端最大接受容量(MB)
     */
    public GrpcClientFactory(Node[] nodes, User clientUser, int messageSize) {
        this.clientUser = clientUser;
        this.readNodes = Arrays.stream(nodes).collect(Collectors.toSet());
        this.messageSize = messageSize;
        nodeConnCountMap = new ConcurrentHashMap<>(nodes.length);
        connNodeMap = new ConcurrentHashMap<>();
    }


    //动态添加一个加节点
    public void addNode(Node node) {
        logger.info("add node:{}", node.getGrpcUrl());
        readNodes.add(node);
        logger.debug("now nodes:{}", readNodes);
    }

    public void delNode(Node node) {
        logger.info("del node:{}", node.getGrpcUrl());
        boolean removed = readNodes.remove(node);
        //当前已经有建立连接，并且存在与待连接节点中，找出该节点建立的连接
        Set<Map.Entry<RpcServiceClient, String>> keepConn = connNodeMap.entrySet();
        if (keepConn.size() > 0  && removed) {
            List<RpcServiceClient> delClients = new ArrayList<>();

            for (Map.Entry<RpcServiceClient, String> entry : keepConn) {
                if (entry.getValue().equals(node.getGrpcUrl())) {
                    logger.debug("found node grpc url:{}", node.getGrpcUrl());
                    RpcServiceClient delClient = entry.getKey();
                    delClients.add(delClient);
                }
            }

            for (RpcServiceClient delClient : delClients) {
                try {
                    //移除连接
                    this.connPool.invalidateObject(delClient, DestroyMode.NORMAL);
                    logger.debug("grpc client destroyed:{}", delClient);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        }

        logger.debug("now nodes:{}", readNodes);
    }


    @Override
    public RpcServiceClient create() throws Exception {
        //用户保存异常节点，用于当次连接时避开错误节点
        List<String> errorNodes = new ArrayList<>();
        //创建一个连接
        RpcServiceClient rpcServiceClient;
        try {
            rpcServiceClient = createRpcClient(errorNodes);
        } finally {
            //最后把errorNodes清理掉，下次错误节点可以继续重试
            errorNodes.clear();
        }
        logger.info("create a new  grpc client:{}....", rpcServiceClient);
        return rpcServiceClient;
    }

    private RpcServiceClient createRpcClient(List<String> errorNodes) {
        //获取连接数最少的节点
        Node node = getLeastConnNode(errorNodes);
        RpcServiceClient rpcServiceClient = null;
        //创建一个连接，直到成功，或者没有节点可以连后抛错
        while (rpcServiceClient == null) {
            try {
                //创建连接后，必须确保连接已经是通了
                rpcServiceClient = RpcServiceClient.newServiceClient(node, clientUser, messageSize);

            } catch (Exception e) {
                //如果创建连接失败,把节点加入到异常节点中，下次获取时避开
                errorNodes.add(node.getGrpcUrl());
                if (errorNodes.size() == readNodes.size()) {
                    logger.error("create chainClient error:no node can use");
                    throw new RuntimeException("create chainClient error:no node can use");
                }
                node = getLeastConnNode(errorNodes);
            }
            //维护rpc 和节点关系
            connNodeMap.put(rpcServiceClient, node.getGrpcUrl());
            AtomicInteger count = nodeConnCountMap.putIfAbsent(node.getGrpcUrl(), new AtomicInteger(0));
            if (count == null) {
                count = nodeConnCountMap.get(node.getGrpcUrl());
            }
            //该节点连接数增加1
            count.incrementAndGet();

        }
        return rpcServiceClient;
    }

    //获取连接最少的节点
    private Node getLeastConnNode(List<String> errorNodes) {
        Node leastNode = null;
        int least = Integer.MAX_VALUE;
        for (Node n : readNodes) {
            //避开错误节点
            if (errorNodes.contains(n.getHostname())) {
                continue;
            }
            //找出连接数最小的节点，刚开始，节点连接数为0
            AtomicInteger nodeCount = nodeConnCountMap.getOrDefault(n.getGrpcUrl(), new AtomicInteger(0));
            if (nodeCount.get() < least) {
                least = nodeCount.get();
                leastNode = n;
            }
        }
        logger.debug("getLeastConnNode grpc url:{}...", leastNode.getGrpcUrl());
        return leastNode;
    }

    @Override
    public PooledObject<RpcServiceClient> wrap(RpcServiceClient client) {
        return new DefaultPooledObject<>(client);
    }

    @Override
    public void destroyObject(PooledObject<RpcServiceClient> p) throws Exception {

        RpcServiceClient rpcServiceClient = p.getObject();
        rpcServiceClient.getManagedChannel().shutdown();
        //节点连接数减掉1
        String grpUrl = connNodeMap.get(rpcServiceClient);
        nodeConnCountMap.get(grpUrl).decrementAndGet();
        //移除连接
        connNodeMap.remove(rpcServiceClient);
        super.destroyObject(p);

        logger.info("destroyObject :{}", rpcServiceClient);
    }


    //检测连接可用性
    @Override
    public boolean validateObject(final PooledObject<RpcServiceClient> p) {
        logger.debug("check validateObject......");
        RpcServiceClient rpcServiceClient = p.getObject();

        ConnectivityState connectivityState = rpcServiceClient.getManagedChannel().getState(true);
        //如果连接grpc通道是可用
        if (connectivityState.equals(ConnectivityState.READY)) {
            logger.debug("{} check alive true", rpcServiceClient.getManagedChannel());
            return true;
            //如果连接grpc通道不可用
        } else if (connectivityState.equals(ConnectivityState.SHUTDOWN)) {
            logger.debug("{} check alive false", rpcServiceClient.getManagedChannel());
            return false;
        } else {
            //调用业务检测
            ChainmakerServer.ChainMakerVersionRequest chainMakerVersionRequest = ChainmakerServer.ChainMakerVersionRequest.newBuilder().build();
            RpcNodeGrpc.RpcNodeFutureStub rpcNodeFutureStub = rpcServiceClient.getRpcNodeFutureStub();
            try {
                rpcNodeFutureStub.getChainMakerVersion(chainMakerVersionRequest).get(rpcCallTimeout, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                //调用失败，再重试一次
                logger.error("check invoke getVersion error one {}", e.getMessage());
                try {
                    rpcNodeFutureStub.getChainMakerVersion(chainMakerVersionRequest).get(rpcCallTimeout, TimeUnit.MILLISECONDS);
                } catch (Exception ex) {
                    logger.error("check invoke getVersion error two:{}", e.getMessage());
                    //第二次尝试失败，返回false不可用
                    return false;
                }
            }
            return true;
        }
    }



    /**
     * 关闭所有连额吉
     */
    public void stopAll() {
          Set<RpcServiceClient> clients = connNodeMap.keySet();

          for(RpcServiceClient rpcServiceClient : clients) {
              try {
                  connPool.invalidateObject(rpcServiceClient);
              } catch (Exception e) {
                  logger.error("invalidate object err:{}",e.getMessage());
                  throw new RuntimeException(e);
              }
          }

    }
}
