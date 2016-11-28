package com.pahlsoft.overload;

import com.pahlsoft.overload.engines.SyntheticTransactionEngine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class LogfileLoadTest {
    static Logger log = LogManager.getLogger(LogfileLoadTest.class);

    public static void main(String[] args) {
        validateArguments(args);
        try {
            runEngine(Integer.parseInt(args[0]), args[1],args[2]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void validateArguments(String[] args) {
        if (args.length !=3 ) {
            log.error("Usage Error: LogfileLoadTest.jar [transacton count] [client name] [service called]");
            System.exit(1);
        }
    }

    private static void runEngine(int transactionCount, String client, String syntheticServiceCalled) throws Exception {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        SyntheticTransactionEngine syntheticTransactionEngine = new SyntheticTransactionEngine(transactionCount,client, syntheticServiceCalled);
        threadPoolExecutor.execute(syntheticTransactionEngine);

        while(threadPoolExecutor.getActiveCount() > 0) {
            Thread.sleep(100L);
        }

        threadPoolExecutor.shutdown();
    }
}
