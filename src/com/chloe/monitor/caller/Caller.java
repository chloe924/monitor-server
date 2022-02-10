package com.chloe.monitor.caller;

import com.chloe.monitor.client.MonitorStrategy;
import com.chloe.monitor.client.NoticeStrategy;

/**
 * Created by Chloe on 2019-02-06
 */

public interface Caller {
    String getCallerId();
    MonitorStrategy getMonitorStrategy();
    void setMonitorStrategy(MonitorStrategy monitorStrategy);
    NoticeStrategy getNoticeStrategy();
    void setNoticeStrategy(NoticeStrategy noticeStrategy);
    long getLastNoticeTime();
    void setLastNoticeTime(long lastNoticeTime);

}
