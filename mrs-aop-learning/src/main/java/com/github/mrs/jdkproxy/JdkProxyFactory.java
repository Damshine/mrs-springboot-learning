package com.github.mrs.jdkproxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * date: 2023/7/28 12:56
 * author: MR.孙
 */
public class JdkProxyFactory {

    public static <T> T create(Class<T> targetClass, InvocationHandler invocationHandler) {
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{targetClass}, invocationHandler);
    }

    @Slf4j
    public static class LogInvocationHandler implements InvocationHandler {

        private Object target;

        public LogInvocationHandler(Object target) {
            this.target = target;
        }


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            log.info("Object proxy ====>{}", proxy);
            log.info("Object[] args ====>{}", args);

            log.info(">>> before");
            Object result = method.invoke(target, args); // 执行被代理方法
            log.info(">>> afterReturning : {}", result);

            return result;
        }
    }


}
