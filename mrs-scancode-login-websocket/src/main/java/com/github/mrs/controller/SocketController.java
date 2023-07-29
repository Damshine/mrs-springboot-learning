package com.github.mrs.controller;

import com.github.mrs.service.UserService;
import com.github.mrs.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * date: 2023/7/29 14:35
 * author: MR.孙
 */
@Controller
public class SocketController {

    @Autowired
    private UserService userService;

    /**
     * 确认身份接口：确定身份以及判断是否二维码过期等
     *
     * @param token
     * @param uuid
     * @return
     */
    @GetMapping(value = "/bindUserIdAndToken")
    @ResponseBody
    public ResponseVO bindUserIdAndToken(@RequestParam("token") String token, @RequestParam("uuid") String uuid) {
        return userService.bindUserIdAndToken(token, uuid);
    }

    @GetMapping("/success.html")
    public String success(){
        return "success";
    }

    @GetMapping("/index.html")
    public String index(){
        return "index";
    }

}
