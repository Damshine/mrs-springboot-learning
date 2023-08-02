package com.github.mrs.rate1.util;

import com.google.common.util.concurrent.RateLimiter;

import java.util.HashMap;
import java.util.Map;

/**
 * date: 2023/8/2 19:21
 * author: MR.孙
 */
public class RateLimitHelper {

    private static Map<String, RateLimiter> rateMap = new HashMap<>();

    private RateLimitHelper() {
    }

    public static RateLimiter getRateLimiter(String limitType, double limitCount) {
        RateLimiter rateLimiter = rateMap.get(limitType);
        if (rateLimiter == null) {
            rateLimiter = RateLimiter.create(limitCount);
            rateMap.put(limitType, rateLimiter);
        }
        return rateLimiter;
    }
}


