package com.github.mrs.annotation;

import java.lang.annotation.*;

/**
 * 多线程事务注解：主事务
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MainTransaction {

    int value();//子线程数量

}
