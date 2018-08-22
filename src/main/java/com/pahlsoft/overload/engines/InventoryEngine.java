package com.pahlsoft.overload.engines;

import com.pahlsoft.overload.generators.InventoryGenerator;
import com.pahlsoft.overload.transports.TcpTransporter;
import com.pahlsoft.overload.transports.Transporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class InventoryEngine implements Runnable {

    static Logger log = LogManager.getLogger(InventoryEngine.class);
    private Properties properties = new Properties();
    private long inventoryQuantity;
    private Transporter transporter;

    public InventoryEngine(long inventoryQuantity) throws Exception {
        this.inventoryQuantity = inventoryQuantity;
        this.loadProperties();
    }

    private void loadProperties() throws IOException {
        Thread currentThread = Thread.currentThread();
        ClassLoader contextClassLoader = currentThread.getContextClassLoader();
        InputStream propertiesStream = contextClassLoader.getResourceAsStream("config.properties");
        if(propertiesStream != null) {
            this.properties.load(propertiesStream);
        } else {
            log.error("No Properties Found");
        }
    }

    public void run() {
        log.info("Initiated Inventory Engine Thread : " + Thread.currentThread().getId() + " Building [" + inventoryQuantity + "] items");
        for (int cycles = 1; cycles <= this.inventoryQuantity; cycles++) {

            try {
                this.transporter = new TcpTransporter();
            } catch (Exception e) {
                if (log.isDebugEnabled()) {
                    e.printStackTrace();
                }
            }

            try {
                this.transporter.sendPayLoad(InventoryGenerator.buildInventoryItem());
                this.transporter.flushTransporter();
            } catch (Exception e) {
                if (log.isDebugEnabled()) {e.printStackTrace();}
            }
        }

    }


}
