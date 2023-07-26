package com.github.mrs.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * date: 2023/7/26 21:38
 * author: MR.孙
 */
@Slf4j
public class CaffeineTest {

    /**
     * Caffeine是基于java8实现的新一代缓存工具，缓存性能接近理论最优。
     * 可以看作是Guava Cache的增强版，功能上两者类似，
     * 不同的是Caffeine采用了一种结合LRU、LFU优点的算法：W-TinyLFU，在性能上有明显的优越性
     */

    public static void main(String[] args) {
        Cache<String, String> cache = Caffeine.newBuilder()
                .initialCapacity(5)
                // 超出时淘汰
                .maximumSize(10)
                //设置写缓存后n秒钟过期
                .expireAfterWrite(60, TimeUnit.SECONDS)
                //设置读写缓存后n秒钟过期,实际很少用到,类似于expireAfterWrite
                //.expireAfterAccess(17, TimeUnit.SECONDS)
                .build();

        String orderId = String.valueOf(123456789);
        String orderInfo = cache.get(orderId, key -> getInfo(key));
        System.out.println(orderInfo);
    }

    private static String getInfo(String orderId) {
        String info = "";
        // 先查询redis缓存
        log.info("get data from redis");

        // 当redis缓存不存在查db
        log.info("get data from mysql");
        info = String.format("{orderId=%s}", orderId);
        return info;
    }

}
