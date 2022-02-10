package com.chloe.monitor.client;

import java.time.LocalDateTime;

/**
 * Created by Chloe on 2019-02-06
 */
public interface MonitorClient extends Runnable{
    long getNextMonitorTime();
    void setNextMonitorTime(long time);

    int getPollInterval();
    void setPollInterval(int interval);
    void setStopTime(LocalDateTime stopTime);

    String getServiceUrl();
    LocalDateTime getStopTime();

    boolean isAlive();

}
