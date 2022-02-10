package com.chloe.monitor.notice.vavle;

import com.chloe.monitor.notice.NoticeContext;
import com.chloe.monitor.notice.NoticeVavle;
import com.chloe.notice.Notice;
import com.chloe.notice.NoticeExcutor;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Chloe on 2019-02-07
 */
public class GenNoticeMsgVavle extends NoticeVavle {
    @Override
    public void vavle(NoticeContext context) {
        Notice notice = new Notice();
        notice.setNoticeType(context.getCaller().getNoticeStrategy().getNoticeType());
        try {
            notice.setFrom("MonitorServer[" + InetAddress.getLocalHost().getHostAddress() + "]");
        } catch (UnknownHostException e) {
            notice.setFrom("MonitorServer[]");
        }
        notice.setTo(context.getCaller().getCallerId());
        notice.setNoticeMsg("can't connect to " + context.getServiceUrl());
        notice.setNoticeTitle("can't connect to " + context.getServiceUrl());

        NoticeExcutor.notice(notice);
    }

}
