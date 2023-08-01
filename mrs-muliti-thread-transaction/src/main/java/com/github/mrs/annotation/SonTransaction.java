package com.github.mrs.annotation;


import java.lang.annotation.*;

/**
 * 多线程事务注解: 子事务
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SonTransaction {

    String value() default "";


}
