package com.github.mrs.cjlib.service;

import lombok.extern.slf4j.Slf4j;

/**
 * date: 2023/7/28 13:54
 * author: MR.孙
 */
@Slf4j
public class HiService {

    public String hi(String name){
        log.info("+++ 执行方法：hi");
        return String.format("hi, %s", name);
    }

}
