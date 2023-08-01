package com.github.mrs.controller;

import com.github.mrs.asserts.Assert;
import com.github.mrs.asserts.SysAssert;
import com.github.mrs.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: TestController
 * date: 2023/7/22 20:05
 * author: MR.孙
 */
@RestController
public class TestController {


    @GetMapping("/test1")
    public String getData1() {
        User user = null;
        // if (user == null) {
        //     throw new Exception("111111111111");
        // }
        Assert.BUSINESS_EXCEPTION.assertNotNull(user);
        return "ok";
    }

    @GetMapping("/test2")
    public String getData2() {
        User user = null;
        // if (user == null) {
        //     throw new Exception("111111111111");
        // }
        SysAssert.SYSTEM_EXCEPTION.assertNotNull(user);
        return "ok";
    }

}
