package com.chloe.monitor.dao;

import com.chloe.monitor.client.MonitorClient;

import java.util.Map;

/**
 * Created by Chloe on 2019-02-06
 */
public interface MonitoredServices {
    Map<String, MonitorClient> getMonitorClients();
    MonitorClient getMonitorClient(String serviceUrl);
    void addMonitorClient(String serviceUrl,MonitorClient client);

}
