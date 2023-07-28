package com.github.mrs.cjlib.service;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * date: 2023/7/28 13:55
 * author: MR.孙
 */
public class CglibFactory {

    public static <T> T create(Class<T> targetClass, MethodInterceptor methodInterceptor) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallback(methodInterceptor);
        return (T) enhancer.create();
    }

    @Slf4j
    public static class LogMethodInterceptor implements MethodInterceptor {

        /**
         * @param target      目标对象
         * @param method      目标方法
         * @param args        参数
         * @param methodProxy 代理方法，注意执行方式  methodProxy.invokeSuper
         * @return
         * @throws Throwable
         */
        @Override
        public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            try {
                log.info(">>> before");
                Object result = methodProxy.invokeSuper(target, args); // 执行被代理方法
                log.info(">>> afterReturning : {}", result);
                return result;
            } catch (Throwable e) {
                log.info(">>> afterThrowing : {}", e.getMessage());
                throw e;
            } finally {
                log.info(">>> after");
            }
        }
    }


}
