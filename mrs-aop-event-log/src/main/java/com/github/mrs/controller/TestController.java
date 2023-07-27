package com.github.mrs.controller;

import com.github.mrs.annotation.Log;
import com.github.mrs.enums.BusinessTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date: 2023/7/27 14:50
 * author: MR.孙
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {


    @Log(title = "测试呢", businessType = BusinessTypeEnum.INSERT)
    @GetMapping("/saveLog")
    public void saveLog(){
        log.info("我就是来测试一下是否成功！");
    }

}
