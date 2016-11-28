package com.pahlsoft.overload.transports;

public interface Transporter {
    void sendPayLoad(Object obj);
    void flushTransporter();

}
