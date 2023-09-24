package com.github.mrs.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/** 配置类(类名一般为模块名+Properties)
 * nobody.json为Starter使用者通过yml配置文件动态修改属性值的变量名前缀
 * @Author Mr.nobody
 * date: 2023/9/24 15:39
 * author: MR.孙
 */
@ConfigurationProperties(prefix = "nobody.json")
public class MyJsonProperties {

    // Starter使用者没在配置文件中配置prefixName属性的值时的默认值
    public static final String DEFAULT_PREFIX_NAME = "@";

    // Starter使用者没在配置文件中配置suffixName属性的值时的默认值
    public static final String DEFAULT_SUFFIX_NAME = "@";

    private String prefixName = DEFAULT_PREFIX_NAME;

    private String suffixName = DEFAULT_SUFFIX_NAME;

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
