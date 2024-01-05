package chainmaker.sdk.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static chainmaker.sdk.demo.InitClient.inItChainClient;

@SpringBootApplication
public class DemoApplication  {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);
        inItChainClient();
        //查询链配置
//        ChainConfig.getChainConfig(InitClient.chainClient);
        //创建合约
//          Contract.createContract(InitClient.chainClient, InitClient.user);
       // 调用合约
        long startTime = System.currentTimeMillis();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        long j = 50;
        for (int i = 0; i < j; i++) {
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    Contract.invokeContract(InitClient.chainClient);
                    //Contract.queryContract(InitClient.chainClient);
                }
            });
        }
        cachedThreadPool.shutdown();
        while(!cachedThreadPool.awaitTermination(1, TimeUnit.SECONDS)){
            System.out.println("线程池未关闭");
        }
        long time = System.currentTimeMillis()-startTime;
        System.out.println("time:" + time + "ms");
        System.out.println("tps:" + ((j*1000)/time));

        //查询合约
         // Contract.queryContract(InitClient.chainClient);
          //根据交易Id查询交易
//          Contract.getTxByTxId(InitClient.chainClient);
          //查询所有的合约名单
//          Contract.getContractlist(InitClient.chainClient);
        //订阅区块
//        new Thread(new Subscribe()).start();
        //等待订阅

//        Thread.sleep(1000 * 10);

        //退出
        System.exit(0);
    }
}

