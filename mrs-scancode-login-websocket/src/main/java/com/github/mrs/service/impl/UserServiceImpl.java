package com.github.mrs.service.impl;

import cn.hutool.json.JSONUtil;
import cn.hutool.jwt.JWTPayload;
import com.github.mrs.server.WebSocketServer;
import com.github.mrs.service.UserService;
import com.github.mrs.util.JwtUtils;
import com.github.mrs.vo.ResponseVO;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * date: 2023/7/29 14:22
 * author: MR.孙
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public ResponseVO bindUserIdAndToken(String token, String uuid) {
        try {
            // 为空
            if (ObjectUtils.isEmpty(token) && ObjectUtils.isEmpty(uuid)) {
                WebSocketServer.sendInfo(JSONUtil.toJsonStr(new ResponseVO(500, "参数不正确", null)), uuid);
                return null;
            }
            // token是否正确
            if (!JwtUtils.jwtApprove(token)) {
                WebSocketServer.sendInfo(JSONUtil.toJsonStr(new ResponseVO(500, "您的token错误", null)), uuid);
                return null;
            }
            // 解析
            JWTPayload jwtPayload = JwtUtils.jwtAnalysis(token);
            String claim = (String) jwtPayload.getClaim("uuid");
            String uid = (String) jwtPayload.getClaim("uid");
            // 判断uuid是否相同
            if (!claim.equals(uuid)) {
                WebSocketServer.sendInfo(JSONUtil.toJsonStr(new ResponseVO(500, "您的token错误", null)), uuid);
                return null;
            }
            // 时间过期，二维码更新
            /**if () {

             }*/
            Map<String, Object> sortedMap = new HashMap<>();
            sortedMap.put("userId", uid);
            sortedMap.put("uuid", uuid);
            ResponseVO responseVO = new ResponseVO(200, "登录成功！", sortedMap);
            WebSocketServer.sendInfo(JSONUtil.toJsonStr(responseVO), uuid);
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
