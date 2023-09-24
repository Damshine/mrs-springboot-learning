package com.github.mrs.strategy;

import org.springframework.stereotype.Component;

/**
 * date: 2023/8/12 14:04
 * author: MR.孙
 */
@Component
public class WechatPay implements Strategy {
    @Override
    public String pay() {
        return "使用微信支付";
    }
}
