package com.github.mrs.annotation;

import com.github.mrs.enums.BusinessTypeEnum;

import java.lang.annotation.*;

/** 自定义操作日志记录注解
 * date: 2023/7/27 13:44
 * author: MR.孙
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {


    String value() default "";
    /**
     * 模块
     */
    String title() default "测试模块";

    /**
     * 功能
     */
    BusinessTypeEnum businessType() default BusinessTypeEnum.OTHER;

}
