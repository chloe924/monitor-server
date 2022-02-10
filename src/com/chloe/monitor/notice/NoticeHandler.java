package com.chloe.monitor.notice;

import com.chloe.monitor.notice.vavle.GenNoticeMsgVavle;
import com.chloe.monitor.notice.vavle.GraceIntervalVavle;
import com.chloe.monitor.notice.vavle.TimeFrameVavle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chloe on 2019-02-07
 */
public class NoticeHandler {
    private List<NoticeVavle> vavles = new ArrayList<>();
    public void addVavle(NoticeVavle vavle) {
        vavles.add(vavle);
    }

    public void handle(NoticeContext ctx) {
        vavles.forEach(v->v.handle(ctx));
    }
}

class NoticeUtil {
    private static NoticeHandler handler= new NoticeHandler();

    static {
        handler.addVavle(new GraceIntervalVavle());
        handler.addVavle(new TimeFrameVavle());
        handler.addVavle(new GenNoticeMsgVavle());
    }

    private NoticeUtil() {}

    public static NoticeHandler getNoticeHandler () {
        return handler;
    }
}