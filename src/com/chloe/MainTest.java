package com.chloe;

import com.chloe.monitor.MonitorExecutor;
import com.chloe.monitor.MonitorServer;
import com.chloe.monitor.caller.Caller;
import com.chloe.monitor.caller.InternalCaller;
import com.chloe.monitor.client.MonitorStrategy;
import com.chloe.monitor.client.NoticeStrategy;
import com.chloe.monitor.dao.impl.MonitoredServicesMemory;
import com.chloe.monitor.dao.impl.RegistedCallersMemory;
import com.chloe.notice.NoticeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.LocalTime;


public class MainTest {
    private static Logger logger = LoggerFactory.getLogger(MainTest.class);

    public static void main(String[] args) {
        MonitorServer server = MonitorExecutor.startMonitorServer(5, 15,
                new MonitoredServicesMemory(), new RegistedCallersMemory());

        Caller c1 = new InternalCaller("caller1");
        server.callerRegister("127.0.0.1:888", c1);
        logger.info("caller1 will receive notice after 1 minutes");
        c1.setNoticeStrategy(new NoticeStrategy(NoticeType.PRINT, 0,
                LocalTime.now().minusHours(1), LocalTime.now().plusMinutes(1)));

        Caller c2 = new InternalCaller("caller2");
        c2.setMonitorStrategy(new MonitorStrategy(LocalDateTime.now().plusDays(1), 2000));
        c2.setNoticeStrategy(new NoticeStrategy(NoticeType.PRINT, 5000));
        server.callerRegister("www.google.com:80", c2);

        Caller c4 = new InternalCaller("caller2");
        c4.setMonitorStrategy(new MonitorStrategy(LocalDateTime.now().plusDays(1), 1000));
        c4.setNoticeStrategy(new NoticeStrategy(NoticeType.PRINT, 1500));
        server.callerRegister("www.google.com:80", c4);

        logger.info("caller3 will receive notice after 5 seconds");
        Caller c3 = new InternalCaller("caller3");
        c3.setMonitorStrategy(new MonitorStrategy(LocalDateTime.now().plusMinutes(1), 2000));
        c3.setNoticeStrategy(new NoticeStrategy(NoticeType.PRINT, 5000));
        server.callerRegister("216.58.217.36:80", c3);

//        logger.info("caller will stop monitor after 1 minutes");
//        Caller c = new InternalCaller("caller");
//        c.setMonitorStrategy(new MonitorStrategy(LocalDateTime.now().plusMinutes(1),5000));
//        for (int i = 8000; i < 9000; i++) {
//            server.callerRegister("127.0.0.1:"+i, c);
//        }


    }


}
