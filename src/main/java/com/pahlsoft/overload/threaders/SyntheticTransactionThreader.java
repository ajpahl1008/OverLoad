package com.pahlsoft.overload.threaders;

import com.pahlsoft.overload.engines.SyntheticTransactionEngine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SyntheticTransactionThreader {
    static Logger log = LogManager.getLogger(SyntheticTransactionThreader.class);

    public static void runEngine(int threadCount, int transactionCount, int simulatedDelayTime, String client, String syntheticServiceCalled)   {

        try {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadCount);

            for (int threads = 0; threads < threadCount; threads++) {
                SyntheticTransactionEngine syntheticTransactionEngine = new SyntheticTransactionEngine(transactionCount, simulatedDelayTime ,client, syntheticServiceCalled);
                threadPoolExecutor.execute(syntheticTransactionEngine);
            }

            while(threadPoolExecutor.getActiveCount() > 0) {
                Thread.sleep(100L);
            }
            threadPoolExecutor.shutdown();
        } catch (Exception e) {
            if (log.isDebugEnabled()) { e.printStackTrace(); }
        }

    }
}
