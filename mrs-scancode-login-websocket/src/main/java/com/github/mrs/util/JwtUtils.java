package com.github.mrs.util;

import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * date: 2023/7/29 14:10
 * author: MR.孙
 */
public class JwtUtils {

    private static String PASSWORD = "JwtUtils";

    /**
     * JWT创建
     */
    public static String jwtCreate(Map<String, Object> map) {
        return JWTUtil.createToken(map, PASSWORD.getBytes());
    }

    /**
     * token解析
     * @param token
     * @return
     */
    public static JWTPayload jwtAnalysis(String token) {
        JWT jwt = JWTUtil.parseToken(token);
        // jwt.getHeader(JWTHeader.TYPE);
        return jwt.getPayload();
    }

    /**
     * JWT认证
     */
    public static boolean jwtApprove(String token) {
        return JWTUtil.verify(token, PASSWORD.getBytes());
    }


    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 从数据库查询一个用户id，这里就随意了
        map.put("uid", UUID.randomUUID().toString());
        //15天
        map.put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);
        String s = jwtCreate(map);
        System.out.println(s);

        JWTPayload payload = jwtAnalysis(s);

        System.out.println(payload);

        JSONObject claimsJson = payload.getClaimsJson();
        System.out.println(claimsJson);
        System.out.println(payload.getClaim("uid"));

    }





}
