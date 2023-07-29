package com.github.mrs.controller;

import cn.hutool.crypto.digest.MD5;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.github.mrs.util.JwtUtils;
import com.github.mrs.vo.HttpUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * date: 2023/7/29 14:26
 * author: MR.孙
 */
@RequestMapping("/user")
@CrossOrigin
@Controller
public class LoginController {


    @Autowired
    private HttpUserVO httpUserVO;

    @ResponseBody
    @GetMapping(value = "/get")
    public String createCodeImg() {
        return "Hello-WebSocket";
    }

    /**
     * 获取登录二维码、放入Token
     */
    @GetMapping(value = "/getLoginQr")
    public void createCodeImg(HttpServletRequest request, HttpServletResponse response) {
        //禁用缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");


        try {
            MD5 md5 = MD5.create();
            // 唯一标识符
            String uuid = md5.digestHex16("uuid");
            response.setHeader("uuid", uuid);
            // 生成token
            Map<String, Object> map = new HashMap<String, Object>();
            // 从数据库查询一个用户id，这里就随意了
            map.put("uid", md5.digestHex16("从数据库查询一个用户id，这里就随意了"));
            map.put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);
            map.put("uuid", uuid);
            //生成token
            String token = JwtUtils.jwtCreate(map);
            //拼成的url http://127.0.0.1:8080/
            String str = httpUserVO.sweepHost() + "/bindUserIdAndToken?token=" + token + "&uuid=" + uuid;

            System.out.println(str);

            //生成二维码
            QrCodeUtil.generate(str, 300, 300, "jpg", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
