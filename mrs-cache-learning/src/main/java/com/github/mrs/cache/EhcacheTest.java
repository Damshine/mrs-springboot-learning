package com.github.mrs.cache;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

/**
 * date: 2023/7/26 21:42
 * author: MR.孙
 */
@Slf4j
public class EhcacheTest {


    /**
     * Encache是一个纯Java的进程内缓存框架，具有快速、精干等特点，是Hibernate中默认的CacheProvider。同Caffeine和Guava Cache相比，Encache的功能更加丰富，扩展性更强：
     *
     * 支持多种缓存淘汰算法，包括LRU、LFU和FIFO
     * 缓存支持堆内存储、堆外存储、磁盘存储（支持持久化）三种
     * 支持多种集群方案，解决数据共享问题
     */
    private static final String ORDER_CACHE = "orderCache";
    public static void main(String[] args) {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                // 创建cache实例
                .withCache(ORDER_CACHE, CacheConfigurationBuilder
                        // 声明一个容量为20的堆内缓存
                        .newCacheConfigurationBuilder(String.class, String.class, ResourcePoolsBuilder.heap(20)))
                .build(true);
        // 获取cache实例
        Cache<String, String> cache = cacheManager.getCache(ORDER_CACHE, String.class, String.class);

        String orderId = String.valueOf(123456789);
        String orderInfo = cache.get(orderId);
        if (StrUtil.isBlank(orderInfo)) {
            orderInfo = getInfo(orderId);
            cache.put(orderId, orderInfo);
        }
        log.info("orderInfo = {}", orderInfo);
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
