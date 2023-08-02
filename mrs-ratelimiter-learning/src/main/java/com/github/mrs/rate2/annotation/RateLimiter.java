package com.github.mrs.rate2.annotation;

import com.github.mrs.rate2.enums.LimitType;

import java.lang.annotation.*;

/**
 * date: 2023/8/2 19:45
 * author: MR.孙
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter {

    /**
     * 限流key
     */
    String key() default "rate_limit:";

    /**
     * 限流时间,单位秒
     */
    int time() default 60;

    /**
     * 限流次数
     */
    int count() default 100;

    /**
     * 限流类型
     */
    LimitType limitType() default LimitType.DEFAULT;

}
