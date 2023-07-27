package com.github.mrs.listener;

import com.github.mrs.entity.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * date: 2023/7/27 14:31
 * author: MR.孙
 */

@Component
public class EventPubListener {

    @Autowired
    private ApplicationContext applicationContext;

    //时间发布方法
    public void pushListener(SysLog sysLogEvent) {

        applicationContext.publishEvent(sysLogEvent);

    }


}
