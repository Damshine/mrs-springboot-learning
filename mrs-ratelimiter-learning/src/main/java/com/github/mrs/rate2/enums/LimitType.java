package com.github.mrs.rate2.enums;

/**
 * date: 2023/8/2 19:44
 * author: MR.孙
 */
public enum LimitType {

    /**
     * 默认策略全局限流
     */
    DEFAULT,
    /**
     * 根据请求者IP进行限流
     */
    IP

}
