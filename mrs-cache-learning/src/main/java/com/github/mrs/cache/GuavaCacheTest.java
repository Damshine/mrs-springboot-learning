package com.github.mrs.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * date: 2023/7/26 21:18
 * author: MR.孙
 */
@Slf4j
public class GuavaCacheTest {


    /**
     *Guava是Google团队开源的一款 Java 核心增强库，包含集合、并发原语、缓存、IO、反射等工具箱，
     * 性能和稳定性上都有保障，应用十分广泛。Guava Cache支持很多特性：
     * 支持最大容量限制
     * 支持两种过期删除策略（插入时间和访问时间）
     * 支持简单的统计功能
     * 基于LRU算法实现
     */
    public static void main(String[] args) throws ExecutionException {

        Cache<String, String> cache = CacheBuilder.newBuilder()
                .initialCapacity(5) //初始容量
                .maximumSize(10) //最大缓存数，超出淘汰
                .expireAfterWrite(60, TimeUnit.SECONDS) //过期时间
                .build();

        String orderID = String.valueOf(123456789);
        //获取orderInfo， 如果不存在， callable中调用getInfo方法返回数据
        String orderInfo = cache.get(orderID, () -> getInfo(orderID));
        log.info("orderInfo = {}", orderInfo);
    }


    private static String getInfo(String orderID) {
        String info = "";

        // 先查询redis缓存
        log.info("get data from redis");

        // redis没有查db
        log.info("get data from mysql");
        info = String.format("{orderID=%s}", orderID);
        return info;
    }

}
