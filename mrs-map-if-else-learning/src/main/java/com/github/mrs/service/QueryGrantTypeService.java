package com.github.mrs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * description: Map + 函数式接口消除if-else
 * date: 2023/7/21 14:06
 * author: MR.孙
 */
@Service
public class QueryGrantTypeService {


    /**  需求：根据优惠券(资源)类型resourceType和编码resourceId查询派发方式grantType
     * 用上了Java8的新特性lambda表达式
         * 判断条件放在key中
         * 对应的业务逻辑放在value中
         * 这样子写的好处是非常直观，能直接看到判断条件对应的业务逻辑
     */

    @Autowired
    private GrantTypeService grantTypeService;

    private Map<String, Function<String, String>> grantTypeMap = new HashMap<>();

    /**
     *  初始化业务分派逻辑,代替了if-else部分
     *  key: 优惠券类型
     *  value: lambda表达式,最终会获得该优惠券的发放方式
     */
    @PostConstruct
    public void dispatcherInit() {
        grantTypeMap.put("红包", resourceId->grantTypeService.redPaper(resourceId));
        grantTypeMap.put("购物券", resourceId->grantTypeService.shopping(resourceId));
        grantTypeMap.put("qq会员", resourceId->grantTypeService.QQVip(resourceId));

    }


    public String getResult(String resourceType) {
        //Controller根据 优惠券类型resourceType、编码resourceId 去查询 发放方式grantType
        Function<String, String> result = grantTypeMap.get(resourceType);
        if (result !=null) {
            //传入resourceId 执行这段表达式获得String型的grantType
            return result.apply("resourceId");
        }

        return "查询不到该优惠券的发放方式";

    }



}
