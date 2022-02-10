package com.chloe.monitor.client;

import com.chloe.monitor.client.impl.SocketMonitorClient;
import com.chloe.monitor.dao.RegistedCallers;
import java.util.concurrent.ExecutorService;

/**
 * Created by Chloe on 2019-02-06
 */
public class MonitorClientFactory {
    private MonitorClientFactory() {}

    public static MonitorClient getMonitorClient(String serviceUrl,
                                                 ExecutorService monitorNoticeExecutePool, RegistedCallers registedCallers) {

        //TODO according serviceUrl to create MonitorClient(socketclient,httpclient etc)
        return new SocketMonitorClient(serviceUrl,monitorNoticeExecutePool,registedCallers);
    }
}
