package com.github.mrs.rate1.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * date: 2023/8/2 18:30
 * author: MR.孙
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface RateConfigAnno {

    String limitType();

    double limitCount() default 5d;

}
