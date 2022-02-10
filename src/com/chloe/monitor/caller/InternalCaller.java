package com.chloe.monitor.caller;

import com.chloe.monitor.MonitorExecutor;
import com.chloe.monitor.client.MonitorStrategy;
import com.chloe.monitor.client.NoticeStrategy;

import java.time.LocalDateTime;

/**
 * Created by Chloe on 2019-02-06
 */
public class InternalCaller implements Caller{
    private String callerId;
    private MonitorStrategy monitorStrategy;
    private NoticeStrategy noticeStrategy;
    private long lastNoticeTime;

    public InternalCaller(String callerId){
        this.callerId = callerId;
        this.monitorStrategy = new MonitorStrategy(LocalDateTime.now().plusYears(MonitorExecutor.DEFAULT_MONITOR_YEARS),
                MonitorExecutor.DEFAULT_MONITOR_INTERVAL);
        this.noticeStrategy = new NoticeStrategy(MonitorExecutor.DEFAULT_NOTICE_TYPE,MonitorExecutor.DEFAULT_GRACE_INTERVAL);
    }

    public String getCallerId() {
        return callerId;
    }

    public MonitorStrategy getMonitorStrategy() {
        return monitorStrategy;
    }

    public void setMonitorStrategy(MonitorStrategy monitorStrategy) {
        this.monitorStrategy = monitorStrategy;
    }

    public NoticeStrategy getNoticeStrategy() {
        return noticeStrategy;
    }

    public void setNoticeStrategy(NoticeStrategy noticeStrategy) {
        this.noticeStrategy = noticeStrategy;
    }

    @Override
    public long getLastNoticeTime() {
        return lastNoticeTime;
    }

    public void setLastNoticeTime(long lastNoticeTime) {
        this.lastNoticeTime = lastNoticeTime;
    }
}
