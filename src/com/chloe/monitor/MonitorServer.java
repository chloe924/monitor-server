package com.chloe.monitor;

import com.chloe.monitor.caller.Caller;
import com.chloe.monitor.client.MonitorClient;
import com.chloe.monitor.client.MonitorClientFactory;
import com.chloe.monitor.dao.MonitoredServices;
import com.chloe.monitor.dao.RegistedCallers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Map;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Chloe on 2019-02-06
 */
public class MonitorServer {
    private static Logger logger = LoggerFactory.getLogger(MonitorServer.class);
    private static AtomicBoolean isRun = new AtomicBoolean(false);

    private static MonitorServer monitorServer;
    private final ExecutorService monitorClientExecutePool;
    private final ExecutorService monitorNoticeExecutePool;
    private final MonitoredServices monitoredServices;
    private final RegistedCallers registedCallers;

    private MonitorServer(int monitorClientThreadPoolSize, int monitorNoticeThreadPoolSize,
                          MonitoredServices monitoredServices, RegistedCallers registedCallers) {
        monitorClientExecutePool = Executors.newFixedThreadPool(monitorClientThreadPoolSize);
        monitorNoticeExecutePool = Executors.newFixedThreadPool(monitorNoticeThreadPoolSize);
        this.monitoredServices = monitoredServices;
        this.registedCallers = registedCallers;
    }

    public static MonitorServer getInstance(int monitorClientThreadPoolSize, int monitorNoticeThreadPoolSize,
                                            MonitoredServices monitoredServices, RegistedCallers registedCallers) {

        synchronized (MonitorServer.class) {
            if (monitorServer == null) {
                monitorServer = new MonitorServer(monitorClientThreadPoolSize, monitorNoticeThreadPoolSize,
                        monitoredServices, registedCallers);
            }
        }

        return monitorServer;
    }


    protected void run() {

        if (isRun.compareAndSet(false, true)) {
            new Thread(() -> {
                while (true) {
                    long now = System.currentTimeMillis();
                    Map<String, MonitorClient> monitored = monitoredServices.getMonitorClients();

                    monitored.entrySet().forEach(entry -> {
                        MonitorClient client = entry.getValue();
                        monitorClientExecutePool.submit(client);
                        client.setNextMonitorTime((System.currentTimeMillis() + client.getPollInterval()));
                        monitoredServices.addMonitorClient(entry.getKey(), client);
                    });


                    long runtime = System.currentTimeMillis() - now;
                    if (runtime > 1000) {
                        //log error, single monitor server performance error
                        logger.error("[{}] performance error !!!!", runtime);
                    }
                }
            }).start();
        }
    }

    public void callerRegister(String serviceUrl, Caller caller) {
        MonitorClient client = monitoredServices.getMonitorClient(serviceUrl);
        if (client == null) {
            client = MonitorClientFactory.getMonitorClient(serviceUrl, monitorNoticeExecutePool, registedCallers);
            client.setNextMonitorTime(System.currentTimeMillis());
            if (caller.getMonitorStrategy() == null) {
                client.setPollInterval(MonitorExecutor.DEFAULT_MONITOR_INTERVAL);
                client.setStopTime(LocalDateTime.now().plusYears(MonitorExecutor.DEFAULT_MONITOR_YEARS));

            } else {
                client.setPollInterval(caller.getMonitorStrategy().getPollInterval());
                client.setStopTime(caller.getMonitorStrategy().getStopTime());
            }
            monitoredServices.addMonitorClient(serviceUrl, client);
        } else {
            if (client.getPollInterval() > caller.getMonitorStrategy().getPollInterval())
                client.setPollInterval(caller.getMonitorStrategy().getPollInterval());
            if (caller.getMonitorStrategy().getStopTime().isAfter(client.getStopTime()))
                client.setStopTime(caller.getMonitorStrategy().getStopTime());

            client.setNextMonitorTime(System.currentTimeMillis());


        }

        registedCallers.addCaller(serviceUrl, caller);
    }

}
