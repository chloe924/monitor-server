package com.chloe.monitor.notice.vavle;


import com.chloe.monitor.notice.NoticeContext;
import com.chloe.monitor.notice.NoticeVavle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Chloe on 2019-02-07
 */
public class GraceIntervalVavle extends NoticeVavle {
    private static Logger logger = LoggerFactory.getLogger(GraceIntervalVavle.class);

    @Override
    public void vavle(NoticeContext context) {
        if (System.currentTimeMillis()-context.getServiceLastAlive()<context.getCaller().getNoticeStrategy().getGraceInterval()) {

            context.setNeedNotice(false);
            logger.info("{} [GraceIntervalVavle] don't need notice to {}",System.currentTimeMillis(), context.getServiceUrl());
        }
    }

}
