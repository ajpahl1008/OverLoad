package com.pahlsoft.overload.transports;

import javax.json.JsonObject;

public interface Transporter {
    void sendPayLoad(JsonObject obj);
    void flushTransporter();

}
