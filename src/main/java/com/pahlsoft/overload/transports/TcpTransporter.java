package com.pahlsoft.overload.transports;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.json.JsonObject;
import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class TcpTransporter implements Transporter {

    static Logger log = LogManager.getLogger(TcpTransporter.class);
    private static String host;
    private static int port;
    private static Socket socket;
    private static DataOutputStream dataOutputStream;
    private static Properties properties = new Properties();

    public TcpTransporter() throws Exception {
        this.loadProperties();
        this.setupConnection();
    }

    public void sendPayLoad(JsonObject jsonObject) {
        try {
            this.dataOutputStream.write(jsonObject.toString().getBytes());
            this.dataOutputStream.write("\n".getBytes());
            this.dataOutputStream.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void loadProperties() throws IOException {
        Thread currentThread = Thread.currentThread();
        ClassLoader contextClassLoader = currentThread.getContextClassLoader();
        InputStream propertyStream = contextClassLoader.getResourceAsStream("config.properties");
        if (propertyStream != null) {
            properties.load(propertyStream);
            host = properties.getProperty("logstash.host");
            port = Integer.parseInt(properties.getProperty("logstash.port"));
        } else {
            log.error("Properties not found");
        }
    }

    private void setupConnection() {
        try {
            this.socket = new Socket(host, port);
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ioe) {
            log.error("Socket Connection Failed");
        }
    }

    public void flushTransporter() {
        try {
            this.dataOutputStream.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


}
