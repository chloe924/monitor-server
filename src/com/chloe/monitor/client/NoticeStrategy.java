package com.chloe.monitor.client;

import com.chloe.notice.NoticeType;

import java.time.LocalTime;

/**
 * Created by Chloe on 2019-02-06
 */
public class NoticeStrategy {
    private NoticeType noticeType;
    private int graceInterval;
    private LocalTime beginTime;
    private LocalTime endTime;

    public NoticeStrategy(NoticeType noticeType, int graceInterval){
        this(noticeType,graceInterval,null,null);
    }

    public NoticeStrategy(NoticeType noticeType, int graceInterval, LocalTime beginTime, LocalTime endTime){
        this.noticeType = noticeType;
        this.graceInterval = graceInterval;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public NoticeType getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(NoticeType noticeType) {
        this.noticeType = noticeType;
    }

    public int getGraceInterval() {
        return graceInterval;
    }

    public void setGraceInterval(int graceInterval) {
        this.graceInterval = graceInterval;
    }

    public LocalTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
