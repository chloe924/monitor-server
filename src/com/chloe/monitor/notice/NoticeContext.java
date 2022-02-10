package com.chloe.monitor.notice;

import com.chloe.monitor.caller.Caller;

/**
 * Created by Chloe on 2019-02-07
 */
public class NoticeContext {
    private boolean needNotice;
    private final String serviceUrl;
    private final long serviceLastAlive;
    private final Caller caller;


    public NoticeContext(String serviceUrl,long serviceLastAlive, Caller caller) {
        this.needNotice = true;
        this.serviceUrl = serviceUrl;
        this.serviceLastAlive = serviceLastAlive;
        this.caller = caller;
    }

    public long getServiceLastAlive() {
        return serviceLastAlive;
    }

    public boolean isNeedNotice() {
        return needNotice;
    }

    public void setNeedNotice(boolean needNotice) {
        this.needNotice = needNotice;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public Caller getCaller() {
        return caller;
    }

}
