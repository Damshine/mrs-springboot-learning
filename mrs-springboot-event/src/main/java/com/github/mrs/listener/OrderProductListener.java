package com.github.mrs.listener;

import com.github.mrs.event.OrderProductEvent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * description: 实现 ApplicationListener 接口，并指定监听的事件类型
 * date: 2023/7/17 21:13
 * author: MR.孙
 */
@Slf4j
@Component
public class OrderProductListener implements ApplicationListener<OrderProductEvent> {


    /** 使用 onApplicationEvent 方法对消息进行接收处理 */
    @SneakyThrows
    @Override
    public void onApplicationEvent(OrderProductEvent event) {
        String orderId = event.getOrderId();
        long start = System.currentTimeMillis();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();

        log.info("{}：校验订单商品价格耗时：({})毫秒", orderId, (end - start));
    }

}
