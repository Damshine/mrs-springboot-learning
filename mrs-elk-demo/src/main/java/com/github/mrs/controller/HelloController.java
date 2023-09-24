package com.github.mrs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date: 2023/9/24 20:55
 * author: MR.孙
 */
@RestController
public class HelloController {

    @GetMapping("/test")
    public String hello() {
        System.out.println("你好世界");
        return "hello";
    }

}
