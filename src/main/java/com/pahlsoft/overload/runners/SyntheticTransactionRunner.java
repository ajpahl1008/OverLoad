package com.pahlsoft.overload.runners;

import com.pahlsoft.overload.threaders.SyntheticTransactionThreader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SyntheticTransactionRunner {
    static Logger log = LogManager.getLogger(SyntheticTransactionRunner.class);

    public static void main(String[] args) {
        validateArguments(args);
        try {
            SyntheticTransactionThreader.runEngine(Integer.parseInt(args[0]), Integer.parseInt(args[1]),Integer.parseInt(args[2]), args[3], args[4]);
        } catch (Exception e) {
            if (log.isDebugEnabled()) {e.printStackTrace();}
        }
    }

    private static void validateArguments(String[] args) {
        if (args.length !=5 ) {
            log.error("Error - Improper Usage, try: pahlsoft-overload.jar [thread count] [transaction count] [simulated delay (ms)] [client name] [service called]");
            System.exit(1);
        }
    }
}
