package com.chloe.monitor.dao.impl;

import com.chloe.monitor.client.MonitorClient;
import com.chloe.monitor.dao.MonitoredServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


/**
 * Created by Chloe on 2019-02-06
 *
 *
 * simple implement
 *
 */
public class MonitoredServicesMemory implements MonitoredServices {
    private static Logger logger = LoggerFactory.getLogger(MonitoredServicesMemory.class);

    private final Map<String, MonitorClient> monitorClients = new ConcurrentHashMap<>();
    @Override
    public Map<String, MonitorClient> getMonitorClients() {
        monitorClients.entrySet().parallelStream()
                .filter(e->e.getValue().getStopTime().isBefore(LocalDateTime.now()))
                .forEach(e->{
                    logger.info("remove client : {} ", e.getKey());
                    monitorClients.remove(e.getKey());
        });

        return monitorClients.entrySet()
                .parallelStream()
                .filter(e -> e.getValue().getNextMonitorTime() <= System.currentTimeMillis())
                .collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public MonitorClient getMonitorClient(String serviceUrl) {
        return monitorClients.get(serviceUrl);
    }

    @Override
    public void addMonitorClient(String serviceUrl,MonitorClient client) {
        monitorClients.put(serviceUrl,client);

    }
}
