package com.github.mrs.rate1.controller;

import com.github.mrs.rate1.annotation.RateConfigAnno;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date: 2023/8/2 19:28
 * author: MR.孙
 */
@RestController
public class OrderController {

    // 每秒只允许一个请求进来
    @GetMapping("/save")
    @RateConfigAnno(limitType = "saveOrder", limitCount = 1)
    public String save(){
        return "success";
    }

}
