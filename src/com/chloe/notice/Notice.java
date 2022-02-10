package com.chloe.notice;

/**
 * Created by Chloe on 2019-02-06
 */
public class Notice {
    private NoticeType noticeType;
    private String noticeTitle;
    private String noticeMsg;
    private String from;
    private String to;

    public NoticeType getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(NoticeType noticeType) {
        this.noticeType = noticeType;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeMsg() {
        return noticeMsg;
    }

    public void setNoticeMsg(String noticeMsg) {
        this.noticeMsg = noticeMsg;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String toString(){
        return "SEND NOTICE ["+ this.noticeType + "] From : " + this.from + " To : "+ this.to
                + " Title : " + this.noticeTitle + " Body : " + this.noticeMsg;
    }
}
