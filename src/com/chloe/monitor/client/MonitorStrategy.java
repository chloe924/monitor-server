package com.chloe.monitor.client;

import java.time.LocalDateTime;

/**
 * Created by Chloe on 2019-02-06
 */
public class MonitorStrategy {
    private int pollInterval;
    private LocalDateTime stopTime;

    public MonitorStrategy(LocalDateTime stopTime,int pollInterval){
        this.pollInterval = pollInterval;
        this.stopTime = stopTime;
    }

    public int getPollInterval() {
        return this.pollInterval;
    }

    public LocalDateTime getStopTime() {
        return this.stopTime;
    }
}
