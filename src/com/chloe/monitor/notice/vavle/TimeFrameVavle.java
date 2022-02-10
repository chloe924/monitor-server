package com.chloe.monitor.notice.vavle;

import com.chloe.monitor.notice.NoticeContext;
import com.chloe.monitor.notice.NoticeVavle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;


/**
 * Created by Chloe on 2019-02-07
 */
public class TimeFrameVavle extends NoticeVavle {
    private static Logger logger = LoggerFactory.getLogger(TimeFrameVavle.class);
    @Override
    public void vavle(NoticeContext context) {
        if (context.getCaller().getNoticeStrategy()!=null
                && context.getCaller().getNoticeStrategy().getBeginTime()!=null
                && context.getCaller().getNoticeStrategy().getEndTime()!=null
                && (LocalTime.now().compareTo(context.getCaller().getNoticeStrategy().getBeginTime())>=0
                   && LocalTime.now().compareTo(context.getCaller().getNoticeStrategy().getEndTime())<=0)){

            context.setNeedNotice(false);
            logger.info("{} [TimeFrameVavle] don't need notice to {} " ,System.currentTimeMillis(), context.getServiceUrl());
        }
    }

}
