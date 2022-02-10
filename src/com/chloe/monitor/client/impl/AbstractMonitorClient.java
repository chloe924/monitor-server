package com.chloe.monitor.client.impl;

import com.chloe.monitor.caller.Caller;
import com.chloe.monitor.client.MonitorClient;
import com.chloe.monitor.dao.RegistedCallers;
import com.chloe.monitor.notice.Notice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/**
 * Created by Chloe on 2019-02-06
 */
public abstract class AbstractMonitorClient implements MonitorClient {
    private static Logger logger = LoggerFactory.getLogger(AbstractMonitorClient.class);
    private long nextMonitorTime;
    private int pollInterval;
    private LocalDateTime stopTime;
    private String serviceUrl;
    private ExecutorService monitorNoticeExecutePool;
    private RegistedCallers registedCallers;
    private long lastAliveTime;

    public AbstractMonitorClient(String serviceUrl,ExecutorService monitorNoticeExecutePool, RegistedCallers registedCallers) {
        this.serviceUrl = serviceUrl;
        this.monitorNoticeExecutePool = monitorNoticeExecutePool;
        this.registedCallers = registedCallers;
        this.lastAliveTime = System.currentTimeMillis();
    }

    @Override
    public long getNextMonitorTime() {
        return this.nextMonitorTime;

    }

    @Override
    public void setNextMonitorTime(long time) {
        this.nextMonitorTime = time;
    }

    @Override
    public int getPollInterval() {
        return this.pollInterval;
    }

    @Override
    public void setPollInterval(int interval) {
        this.pollInterval = interval;
    }

    @Override
    public void setStopTime(LocalDateTime stopTime) {
        this.stopTime = stopTime;
    }

    @Override
    public LocalDateTime getStopTime() {
        return this.stopTime;
    }

    @Override
    public String getServiceUrl() {
        return serviceUrl;
    }


    @Override
    public void run() {
        if (!isAlive()) {
            logger.error("NOT ALIVE : {}", serviceUrl);

            Set<Caller> callers = registedCallers.getRegistedCallers(serviceUrl);

            for (Caller c : callers) {
                Notice nc = new Notice(serviceUrl,lastAliveTime,c);
                monitorNoticeExecutePool.submit(nc);
            }
        }else {
            lastAliveTime = System.currentTimeMillis();
            logger.info("SUCCESS CONNECTED : {}", serviceUrl);
        }
    }


}
