package org.chainmaker.sdk;

import org.chainmaker.pb.common.ChainmakerTransaction;
import org.chainmaker.pb.common.Request;
import org.chainmaker.pb.txpool.TransactionPool;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class TestTxPool extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(TestTxPool.class);


    @Test
    public void testGetPoolStatus() {

        try {
            TransactionPool.TxPoolStatus txPoolStatus = chainClient.getPoolStatus(rpcCallTimeout);
            logger.debug("交易池配置状态开始:====================");
            logger.debug("{}", txPoolStatus);
            logger.debug("交易池配置状态结束:====================");
            Assert.assertNotNull(txPoolStatus);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void testGetTxIdsByTypeAndStage() {
        try {

            List<String> txIds = chainClient.getTxIdsByTypeAndStage(TransactionPool.TxType.ALL_TYPE, TransactionPool.TxStage.ALL_STAGE, rpcCallTimeout);
            logger.debug("txIds:{}", txIds);
            Assert.assertNotNull(txIds);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void testGetTxsInPoolByTxIds() {
        try {

            List<String> txIds = chainClient.getTxIdsByTypeAndStage(TransactionPool.TxType.ALL_TYPE, TransactionPool.TxStage.ALL_STAGE, rpcCallTimeout);

            List<ChainmakerTransaction.Transaction> txs = chainClient.getTxsInPoolByTxIds(new String[]{txIds.get(0)}, rpcCallTimeout);

            logger.debug("txs:{}", txs);
            Assert.assertNotNull(txs);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
