package com.chloe.notice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Chloe on 2019-02-06
 *
 *
 * indepent notice service
 */
public class NoticeExcutor {
    private static Logger logger = LoggerFactory.getLogger(NoticeExcutor.class);

    private NoticeExcutor(){}

    public static void notice(Notice notice) {
        logger.info("SEND NOTICE : {}",notice);
    }
}
