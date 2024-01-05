package chainmaker.sdk.demo;

import org.chainmaker.pb.common.ChainmakerTransaction;
import org.chainmaker.pb.common.ContractOuterClass;
import org.chainmaker.pb.common.Request;
import org.chainmaker.pb.common.ResultOuterClass;
import org.chainmaker.sdk.ChainClient;
import org.chainmaker.sdk.User;
import org.chainmaker.sdk.utils.FileUtils;
import org.chainmaker.sdk.utils.SdkUtils;

import java.util.HashMap;
import java.util.Map;


public class Contract {

    private static final String QUERY_CONTRACT_METHOD = "find_by_file_hash";
    private static final String INVOKE_CONTRACT_METHOD = "UploadResult";
//    private static final String CONTRACT_NAME = "counter_sdk_java_demo";
    private static final String CONTRACT_NAME = "ResultContract";
    private static final String CONTRACT_FILE_PATH = "rust-fact-2.0.0.wasm";

    public static void createContract(ChainClient chainClient, User user) {
        ResultOuterClass.TxResponse responseInfo = null;
        try {
            byte[] byteCode = FileUtils.getResourceFileBytes(CONTRACT_FILE_PATH);

            // 1. create payload
            Request.Payload payload = chainClient.createContractCreatePayload(CONTRACT_NAME, "1", byteCode,
                    ContractOuterClass.RuntimeType.WASMER, null);
            //2. create payloads with endorsement
            Request.EndorsementEntry[] endorsementEntries = SdkUtils
                    .getEndorsers(payload, new User[]{user});

            // 3. send request
            responseInfo = chainClient.sendContractManageRequest(payload, endorsementEntries, 10000, 10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("创建合约结果：");
        System.out.println(responseInfo);
    }
    public static void invokeContract(ChainClient chainClient) {
        ResultOuterClass.TxResponse responseInfo = null;
        Map<String, byte[]> stringMap1 = new HashMap<>();

        stringMap1.put("result", "id004".getBytes());
        //stringMap1.put("file_name", "F:\\14145545452+646326+4523+65423+65432.txt".getBytes());
        //stringMap1.put("time", "2022.11.453254354354354310".getBytes());

        try {
            responseInfo = chainClient.invokeContract(CONTRACT_NAME, INVOKE_CONTRACT_METHOD,
                    null, stringMap1,10000, 10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("执行合约结果：");
        System.out.println(responseInfo);

    }

    public static void queryContract(ChainClient chainClient) {
        ResultOuterClass.TxResponse responseInfo = null;
        try {
            responseInfo = chainClient.queryContract(CONTRACT_NAME, QUERY_CONTRACT_METHOD,
                    null,  null,10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("查询合约结果：");
        System.out.println(responseInfo);
    }

    public static void getTxByTxId(ChainClient chainClient){
        ChainmakerTransaction.TransactionInfo transactionInfo = null;
        try{
            transactionInfo = chainClient.getTxByTxId("9c901f363ddb03739a264a93b89490d1beb2e56ad3e19550aea1aa348154eee5",10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("根据交易Id查询交易的结果：");
        System.out.println(transactionInfo);
    }

    public static void getContractlist(ChainClient chainClient){
        String contractlist = null;
        try {
            contractlist = chainClient.getContractInfo("02", 10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("查询的合约名称：");
        System.out.println(contractlist);
    }
}
