package com.chloe.monitor.notice;


import java.util.List;

/**
 * Created by Chloe on 2019-02-07
 */
public abstract class NoticeVavle {
    public abstract void vavle(NoticeContext context);


    public void handle(NoticeContext context) {
        if (context.isNeedNotice()) {
            vavle(context);
        }
    }
}
