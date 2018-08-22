package com.pahlsoft.overload.runners;

import com.pahlsoft.overload.threaders.InventoryEngineThreader;
import com.pahlsoft.overload.threaders.SyntheticTransactionThreader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InventoryEngineRunner {
    static Logger log = LogManager.getLogger(InventoryEngineRunner.class);

    public static void main(String[] args) {
        validateArguments(args);
        try {
            InventoryEngineThreader.runEngine(Integer.parseInt(args[0]), Long.parseLong(args[1]));
        } catch (Exception e) {
            if (log.isDebugEnabled()) {e.printStackTrace();}
        }
    }

    private static void validateArguments(String[] args) {
        if (args.length !=2 ) {
            log.error("Error - Improper Usage, try: pahlsoft-overload.jar [numThreads] [numInventoryItems]");
            System.exit(1);
        }
    }
}
