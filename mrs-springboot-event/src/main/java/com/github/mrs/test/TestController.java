package com.github.mrs.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * date: 2023/8/12 14:05
 * author: MR.孙
 */
@RestController
public class TestController {

    @Autowired
    private Map<String, Strategy> strategyMap = new ConcurrentHashMap<>();

    @Autowired
    public TestController(Map<String, Strategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Resource
    private ApplicationContext applicationContext;

    @GetMapping("/test")
    public String getPayResult() {
        // strategyMap.forEach((k, v) -> {
        //     System.out.println(k + v);
        // });
        Strategy aliPay = applicationContext.getBean("aliPay", Strategy.class);
        System.out.println(aliPay.pay());
        return "123";
    }

}
