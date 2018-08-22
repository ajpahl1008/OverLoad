package com.pahlsoft.overload.threaders;

import com.pahlsoft.overload.engines.InventoryEngine;
import com.pahlsoft.overload.engines.SyntheticTransactionEngine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class InventoryEngineThreader {
    static Logger log = LogManager.getLogger(InventoryEngineThreader.class);

    public static void runEngine(int threadCount, long inventoryTotal)   {

        try {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadCount);

            long remainder = inventoryTotal % threadCount;
            long lastThread = inventoryTotal/threadCount + remainder;

            for (int threads = 0; threads < threadCount; threads++) {
                if (threads == threadCount - 1 ) {
                    InventoryEngine inventoryEngine = new InventoryEngine(lastThread);
                    threadPoolExecutor.execute(inventoryEngine);
                } else {
                    InventoryEngine inventoryEngine = new InventoryEngine(inventoryTotal/threadCount);
                    threadPoolExecutor.execute(inventoryEngine);
                }
            }

            System.out.print("Waiting on Threads to Wrap Up.");
            while(threadPoolExecutor.getActiveCount() > 0) {
                Thread.sleep(1000);
                System.out.print(".");
            }
            Thread.sleep(1000);
            threadPoolExecutor.shutdown();
        } catch (Exception e) {
            if (log.isDebugEnabled()) { e.printStackTrace(); }
        }

    }
}
