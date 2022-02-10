package com.chloe.monitor;

import com.chloe.monitor.dao.MonitoredServices;
import com.chloe.monitor.dao.RegistedCallers;
import com.chloe.notice.NoticeType;


/**
 * Created by Chloe on 2019-02-06
 */
public class MonitorExecutor {
    public static final int DEFAULT_MONITOR_INTERVAL = 4000;
    public static final int DEFAULT_MONITOR_YEARS = 1;
    public static final NoticeType DEFAULT_NOTICE_TYPE = NoticeType.PRINT;
    public static final int DEFAULT_GRACE_INTERVAL = 5;

    private MonitorExecutor() {
    }

    private static MonitorServer server;

    public static MonitorServer startMonitorServer(int monitorClientThreadPoolSize, int monitorNoticeThreadPoolSize,
                                                   MonitoredServices monitoredServices, RegistedCallers registedCallers) {

        synchronized (MonitorExecutor.class) {
            if (server == null) {
                server = MonitorServer.getInstance(monitorClientThreadPoolSize, monitorNoticeThreadPoolSize,
                        monitoredServices, registedCallers);
            }
        }

        server.run();
        return server;
    }

}
