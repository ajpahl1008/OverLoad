package com.pahlsoft.overload.engines;

import com.pahlsoft.overload.transports.TcpTransporter;
import com.pahlsoft.overload.transports.Transporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.*;

public class SyntheticTransactionEngine implements Runnable {

    static Logger log = LogManager.getLogger(SyntheticTransactionEngine.class);
    private Properties properties = new Properties();
    private int transactionCount;
    private int simulatedDelayTime;
    private String client;
    private String syntheticServiceCalled;
    private Transporter transporter;
    private ArrayList<String> transactions = new ArrayList();
    private ArrayList<String> clients = new ArrayList();

    public SyntheticTransactionEngine(int transactionCount,int simulatedDelayTime, String client, String syntheticServiceCalled) throws Exception {
        this.transactionCount = transactionCount;
        this.simulatedDelayTime = simulatedDelayTime;
        this.client = client;
        this.syntheticServiceCalled = syntheticServiceCalled;
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
        log.info("Initiated Client Transaction Engine Thread : " + Thread.currentThread().getId());
        for (int cycles = 0; cycles <= this.transactionCount; cycles++) {

            try {
                this.transporter = new TcpTransporter();
            } catch (Exception e) {
                if (log.isDebugEnabled()) {
                    e.printStackTrace();
                }
            }

            Random randomNumber = new Random();
            Date date = new Date();

            if(this.client == null || this.client.isEmpty()) {
                this.client = this.clients.get(randomNumber.nextInt(this.clients.size()));
            }

            if (this.syntheticServiceCalled == null || this.syntheticServiceCalled.isEmpty()) {
                this.syntheticServiceCalled = this.transactions.get(randomNumber.nextInt(this.transactions.size()));
            }

            JsonObject jsonPayLoad = Json.createObjectBuilder().add("transaction_time",(new Timestamp(date.getTime())).toString())
                                                               .add("transaction_duration",(randomNumber.nextInt(150)))
                                                               .add("transaction_client",this.client)
                                                               .add("transaction_called",this.syntheticServiceCalled)
                                                               .build();
            try {
                log.info(jsonPayLoad.toString());
                this.transporter.sendPayLoad(jsonPayLoad);
                this.transporter.flushTransporter();
                Thread.sleep(simulatedDelayTime);
            } catch (Exception e) {
                if (log.isDebugEnabled()) {e.printStackTrace();}
            }
        }

    }


}
