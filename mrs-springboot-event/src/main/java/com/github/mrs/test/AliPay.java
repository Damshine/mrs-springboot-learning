package com.github.mrs.test;

import org.springframework.stereotype.Component;

/**
 * date: 2023/8/12 14:04
 * author: MR.孙
 */
@Component
public class AliPay implements Strategy{

    @Override
    public String pay() {
        return "使用支付宝支付";
    }

}
