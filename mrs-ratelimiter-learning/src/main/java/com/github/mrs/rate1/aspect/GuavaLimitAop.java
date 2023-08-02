package com.github.mrs.rate1.aspect;

import com.alibaba.fastjson.JSONObject;
import com.github.mrs.rate1.annotation.RateConfigAnno;
import com.github.mrs.rate1.util.RateLimitHelper;
import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * date: 2023/8/2 18:31
 * author: MR.孙
 */
@Aspect
@Component
public class GuavaLimitAop {

    private static Logger logger = LoggerFactory.getLogger(GuavaLimitAop.class);


    @Before("@annotation(com.github.mrs.rate1.annotation.RateConfigAnno)")
    public void limit(JoinPoint joinPoint) {

        //1、获取当前的调用方法
        Method currentMethod = getCurrentMethod(joinPoint);
        if (Objects.isNull(currentMethod)) {
            return;
        }

        //2、从方法注解定义上获取限流的类型
        String limitType = currentMethod.getAnnotation(RateConfigAnno.class).limitType();
        double limitCount = currentMethod.getAnnotation(RateConfigAnno.class).limitCount();

        //使用guava的令牌桶算法获取一个令牌，获取不到先等待
        RateLimiter rateLimiter = RateLimitHelper.getRateLimiter(limitType, limitCount);
        boolean b = rateLimiter.tryAcquire();
        if (b) {
            System.out.println("获取到令牌");
        }else {
            HttpServletResponse resp = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success", false);
            jsonObject.put("msg", "限流中");
            try {
                output(resp, jsonObject.toJSONString());
            }catch (Exception e){
                logger.error("error,e:{}",e);
            }
        }


    }


    private Method getCurrentMethod(JoinPoint joinPoint) {
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        Method target = null;
        for (Method method : methods) {
            if (method.getName().equals(joinPoint.getSignature().getName())) {
                target = method;
                break;
            }
        }
        return target;
    }

    public void output(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(msg.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.flush();
            outputStream.close();
        }
    }


}
