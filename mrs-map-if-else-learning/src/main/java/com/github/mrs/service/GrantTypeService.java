package com.github.mrs.service;

import org.springframework.stereotype.Service;

/**
 * description: 优惠券等具体发放业务
 * date: 2023/7/21 14:05
 * author: MR.孙
 */
@Service
public class GrantTypeService {

    public String redPaper(String resourceId){
        //红包的发放方式
        return "每周末9点发放";
    }
    public String shopping(String resourceId){
        //购物券的发放方式
        return "每周三9点发放";
    }
    public String QQVip(String resourceId){
        //qq会员的发放方式
        return "每周一0点开始秒杀";
    }


}
