package org.chainmaker.sdk;

import org.chainmaker.pb.common.ResultOuterClass;
import org.chainmaker.sdk.config.NodeConfig;
import org.chainmaker.sdk.utils.FileUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestChainClientPool extends TestBase {

    private static final String INVOKE_CONTRACT_METHOD = "increase";
    private static final String CONTRACT_NAME = "counter";

    @Test
    public void testChangeUser() throws Exception {

        ResultOuterClass.TxResponse responseInfo = null;
        try {
            responseInfo = chainClient.invokeContract(CONTRACT_NAME, INVOKE_CONTRACT_METHOD,
                    null, null, rpcCallTimeout, syncResultTimeout);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(responseInfo);


        User clientUser = new User("wx-org2.chainmaker.org", FileUtils.getResourceFileBytes("crypto-config/wx-org2.chainmaker.org/user/client1/client1.sign.key"),
                FileUtils.getResourceFileBytes("crypto-config/wx-org2.chainmaker.org/user/client1/client1.sign.crt"),
                FileUtils.getResourceFileBytes("crypto-config/wx-org2.chainmaker.org/user/client1/client1.tls.key"),
                FileUtils.getResourceFileBytes("crypto-config/wx-org2.chainmaker.org/user/client1/client1.tls.crt"), false);


        chainClient.setClientUser(clientUser);


        try {
            responseInfo = chainClient.invokeContract(CONTRACT_NAME, INVOKE_CONTRACT_METHOD,
                    null, null, rpcCallTimeout, syncResultTimeout);

            Assert.assertNotNull(responseInfo);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void testIdeaTime() throws Exception {

        //默认配置了3个连接
        RpcServiceClient r1 = chainClient.getConnectionPool().borrowObject();

        System.out.println("空闲连接：" + chainClient.getConnectionPool().getNumIdle());


        System.out.println("归还一个连接");
        chainClient.getConnectionPool().returnObject(r1);
        System.out.println("空闲连接：" + chainClient.getConnectionPool().getNumIdle());

        Thread.sleep(1000 * 40);
        //空闲连接默认保活30分钟，每隔10s检测一次可用性。因为未超过保活时间，所以这里未关闭
        System.out.println("空闲连接：" + chainClient.getConnectionPool().getNumIdle());


    }

    @Test
    public void testConnFailure() throws Exception {

        //先申请3个连接，连接满了
        RpcServiceClient r1 = chainClient.getConnectionPool().borrowObject();

        RpcServiceClient r2 = chainClient.getConnectionPool().borrowObject();

        RpcServiceClient r3 = chainClient.getConnectionPool().borrowObject();
        System.out.println("空闲连接：" + chainClient.getConnectionPool().getNumIdle());


        System.out.println("归还一个连接");
        chainClient.getConnectionPool().returnObject(r1);
        //归还连接后，立即关闭一个连接
        r1.getManagedChannel().shutdownNow();
        Thread.sleep(1000 * 30);
        System.out.println("空闲连接：" + chainClient.getConnectionPool().getNumIdle());

        System.out.println("从连接池中获取一个连接.....");
        //再获取一个连接
        r3 = chainClient.getConnectionPool().borrowObject();

    }

    @Test
    public void testChangeNode() throws Exception {
        RpcServiceClient r1 = chainClient.getConnectionPool().borrowObject();
        RpcServiceClient r2 = chainClient.getConnectionPool().borrowObject();


        NodeConfig nodeConfig = new NodeConfig();
        nodeConfig.setNodeAddr("127.0.0.1:12302");
        nodeConfig.setEnableTls(true);
        nodeConfig.setTlsHostName("chainmaker.org");
        nodeConfig.setTrust_root_paths(new String[]{"src/test/resources/crypto-config/wx-org1.chainmaker.org/ca", "src/test/resources/crypto-config/wx-org2.chainmaker.org/ca"});
        System.out.println("动态删除一个节点......");
        chainClient.delNode(nodeConfig);
        //重复删除节点
        chainClient.delNode(nodeConfig);

        RpcServiceClient r3 = chainClient.getConnectionPool().borrowObject();

        System.out.println("动态添加一个节点......");
        chainClient.addNode(nodeConfig);
        //重复添加节点
        chainClient.addNode(nodeConfig);

        RpcServiceClient r4 = chainClient.getConnectionPool().borrowObject();
        System.out.println(r4);
    }


    @Test
    public void testBlock() throws Exception {
        RpcServiceClient r1 = chainClient.getConnectionPool().borrowObject();
        RpcServiceClient r2 = chainClient.getConnectionPool().borrowObject();
        RpcServiceClient r3 = chainClient.getConnectionPool().borrowObject();
        RpcServiceClient r4 = chainClient.getConnectionPool().borrowObject();
        System.out.println(chainClient.getConnectionPool().getNumActive());
    }

    @Test
    public void testStop() throws Exception {
        RpcServiceClient r1 = chainClient.getConnectionPool().borrowObject();
        RpcServiceClient r2 = chainClient.getConnectionPool().borrowObject();
        RpcServiceClient r3 = chainClient.getConnectionPool().borrowObject();
        Assert.assertEquals(chainClient.getConnectionPool().getNumActive(),3);
        chainClient.stop();
        Assert.assertEquals(chainClient.getConnectionPool().getNumActive(),0);
    }


}
