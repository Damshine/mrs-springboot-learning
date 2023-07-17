package com.github.mrs.service;

import com.github.mrs.event.MsgEvent;
import com.github.mrs.event.OrderProductEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * description:
 * date: 2023/7/17 21:19
 * author: MR.孙
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    /** 注入ApplicationContext用来发布事件 */
    private final ApplicationContext applicationContext;

    /**
     * 下单
     * @param orderId 订单id
     * @return
     */
    public String buyOrder(String orderId) {
        long start = System.currentTimeMillis();
        //1. 查询订单详情

        //2. 校验订单的价格(同步处理)
        applicationContext.publishEvent(new OrderProductEvent(this, orderId));
        //3. 短信处理(异步处理)
        applicationContext.publishEvent(new MsgEvent(orderId));



        long end = System.currentTimeMillis();
        log.info("任务全部完成，总耗时：({})毫秒", end - start);
        return "购买成功";
    }

}
