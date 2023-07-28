package com.github.mrs.cjlib;

import com.github.mrs.cjlib.service.CglibFactory;
import com.github.mrs.cjlib.service.HiService;

/**
 * date: 2023/7/28 14:01
 * author: MR.孙
 */
public class CglibTest {

    public static void main(String[] args) {
        HiService hiService = CglibFactory.create(HiService.class, new CglibFactory.LogMethodInterceptor());
        hiService.hi("Cglib");
    }

}
