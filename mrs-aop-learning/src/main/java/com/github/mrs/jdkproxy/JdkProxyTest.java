package com.github.mrs.jdkproxy;

import com.github.mrs.jdkproxy.service.HelloService;
import com.github.mrs.jdkproxy.service.impl.HelloServiceImpl;

/**
 * date: 2023/7/28 13:16
 * author: MR.孙
 */
public class JdkProxyTest {


    public static void main(String[] args) {
        HelloService helloService = JdkProxyFactory.create(HelloService.class, new JdkProxyFactory.LogInvocationHandler(new HelloServiceImpl()));
        helloService.hello("JDK Proxy");
    }

}
