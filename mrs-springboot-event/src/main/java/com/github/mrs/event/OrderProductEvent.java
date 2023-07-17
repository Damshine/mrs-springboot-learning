package com.github.mrs.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * description: 生产订单事件
 * date: 2023/7/17 21:06
 * author: MR.孙
 */
@Data
public class OrderProductEvent extends ApplicationEvent {

    /** 该类型事件携带的信息 */
    private String orderId;

    public OrderProductEvent(Object source, String orderId) {
        super(source);
        this.orderId = orderId;
    }
}
