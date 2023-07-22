package com.github.mrs.controller;

import com.github.mrs.enums.ResponseEnum;
import com.github.mrs.po.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: TestController
 * date: 2023/7/22 20:05
 * author: MR.孙
 */
@RestController
public class TestController {


    @GetMapping("/test")
    public String getData() {
        User user = null;
        // if (user == null) {
        //     throw new Exception("111111111111");
        // }
        ResponseEnum.BAD_LICENCE_TYPE.assertNotNull(user);
        return "ok";
    }

}
