package com.github.mrs.jdkproxy.service.impl;

import com.github.mrs.jdkproxy.service.HelloService;
import lombok.extern.slf4j.Slf4j;

/**
 * date: 2023/7/28 12:49
 * author: MR.孙
 */
@Slf4j
public class HelloServiceImpl implements HelloService {


    @Override
    public String hello(String name) {
        log.info("+++ 执行方法：hello");
        return String.format("hello, %s", name);
    }

}
