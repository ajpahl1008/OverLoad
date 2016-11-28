package com.pahlsoft.overload.factories;

import com.pahlsoft.overload.transports.TcpTransporter;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class TcpTransporterFactory {

    public TcpTransporterFactory() {

    }

    public TcpTransporter create() throws Exception {
        return new TcpTransporter();
    }

    public PooledObject<TcpTransporter> wrap(TcpTransporter buffer) { return new DefaultPooledObject(buffer);};

    public void passivateObject(PooledObject<TcpTransporter> pooledObject) {
        ((TcpTransporter)pooledObject.getObject()).flushTransporter();
    }

}
