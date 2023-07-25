package com.github.mrs.dynamicloglevel.controller;


import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * description:
 * date: 2023/7/25 15:48
 * author: MR.孙
 */
@Slf4j
@RestController
@RequestMapping("/log")
public class LogBackLevelController {

    @RequestMapping("/update")
    public Map<String, Object> updateLogLevel(@RequestParam String level) {

        HashMap<String, Object> result = new HashMap<>();

        //获取LoggerContext实例
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        //获取RootLogger并设置日志级别
        loggerContext.getLogger("ROOT").setLevel(Level.DEBUG);
        loggerContext.getLogger("com.github.mrs").setLevel(Level.valueOf(level));

        result.put("code", 0);
        result.put("msg", "success");
        result.put("data", null);

        return result;
    }


    @GetMapping("/test")
    public void test() {
        log.trace("time: {}", LocalDateTime.now());
        log.debug("time: {}", LocalDateTime.now());
        log.info("time: {}", LocalDateTime.now());
        log.warn("time: {}", LocalDateTime.now());
        log.error("time: {}", LocalDateTime.now());
    }




}
