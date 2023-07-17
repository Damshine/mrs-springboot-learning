package com.github.mrs.event;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * description:
 * date: 2023/7/17 21:43
 * author: MR.孙
 */
@Data
@AllArgsConstructor
public class MsgEvent {

    /** 该类型事件携带的信息 */
    public String orderId;

}
