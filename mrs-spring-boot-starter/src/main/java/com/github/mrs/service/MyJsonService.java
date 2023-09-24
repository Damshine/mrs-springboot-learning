package com.github.mrs.service;

import com.alibaba.fastjson.JSON;

/** 业务处理类 实现 Java 对象转换为带有指定前后缀的 JSON 字符串。
 * date: 2023/9/24 15:39
 * author: MR.孙
 */
public class MyJsonService {

    // 前缀
    private String prefixName;
    // 后缀
    private String suffixName;

    /**
     * 将Java对象转为带有指定前后缀的JSON字符串
     *
     * @param o 需要转换的Java对象
     * @return 转换后的字符串
     */
    public String objectToMyJson(Object o) {
        return prefixName + JSON.toJSONString(o) + suffixName;
    }

    public String getPrefixName() {
        return prefixName;
    }

    public void setPrefixName(String prefixName) {
        this.prefixName = prefixName;
    }

    public String getSuffixName() {
        return suffixName;
    }

    public void setSuffixName(String suffixName) {
        this.suffixName = suffixName;
    }

}
