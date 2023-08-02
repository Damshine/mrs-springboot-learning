package com.github.mrs.rate2.controller;

import com.github.mrs.rate2.annotation.RateLimiter;
import com.github.mrs.rate2.enums.LimitType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * date: 2023/8/2 20:54
 * author: MR.孙
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    @RateLimiter(time = 5, count = 3, limitType = LimitType.IP)
    public String hello() {
        return "hello>>>" + new Date();
    }

}
