package com.github.mrs.controller;

import com.github.mrs.annotation.RepeatSubmit;
import com.github.mrs.pojo.Result;
import com.github.mrs.pojo.SysLog;
import com.github.mrs.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date: 2023/8/1 22:08
 * author: MR.孙
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private SysLogService sysLogService;

    // 默认1s，方便测试查看，写10s
    @RepeatSubmit(expireTime = 10)
    @PostMapping("/saveSysLog")
    public Result saveSysLog(@RequestBody SysLog sysLog){
        return Result.success(sysLogService.saveSyslog(sysLog));
    }

}
