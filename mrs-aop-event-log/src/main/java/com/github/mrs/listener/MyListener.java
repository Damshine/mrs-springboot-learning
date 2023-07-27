package com.github.mrs.listener;

import com.github.mrs.entity.SysLog;
import com.github.mrs.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * date: 2023/7/27 14:37
 * author: MR.孙
 */
@Slf4j
@Component
public class MyListener {

    @Autowired
    private TestService testService;


    @Async
    @EventListener(SysLog.class)
    public void saveLog(SysLog event) {
        log.info("=====即将异步保存到数据库======");

        testService.saveLog(event);
    }


}
