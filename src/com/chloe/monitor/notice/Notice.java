package com.chloe.monitor.notice;

import com.chloe.monitor.caller.Caller;

/**
 * Created by Chloe on 2019-02-06
 */
public class Notice implements Runnable{
    private Caller caller;
    private String serviceUrl;
    private long serviceLastAlive;
    public Notice(String serviceUrl,long serviceLastAlive, Caller caller) {
        this.caller = caller;
        this.serviceUrl = serviceUrl;
        this.serviceLastAlive = serviceLastAlive;
    }

    @Override
    public void run() {
        NoticeContext nc = new NoticeContext(serviceUrl,serviceLastAlive,caller);
        NoticeHandler handler = NoticeUtil.getNoticeHandler();
        handler.handle(nc);
    }

}
