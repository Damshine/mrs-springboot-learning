package com.github.mrs.config;

import com.github.mrs.service.MyJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**  自动装配类
 * date: 2023/9/24 15:45
 * author: MR.孙
 */
@Configuration // 标识此类是配置类
@ConditionalOnClass(MyJsonService.class) // 表示只有指定的class在classpath上时MyJsonConfiguration才能被注册
@EnableConfigurationProperties(MyJsonProperties.class) // 激活@ConfigurationProperties
public class MyJsonConfiguration {

    private MyJsonProperties myJsonProperties;


    @Autowired
    ApplicationContext applicationContext;


    // 自动注入配置类
    public MyJsonConfiguration(MyJsonProperties myJsonProperties) {
        this.myJsonProperties = myJsonProperties;
    }

    //创建MyJsonService对象，注入到Spring容器中
    @Bean
    @ConditionalOnMissingBean(MyJsonService.class) // 当容器没有此bean时，才注册
    public MyJsonService myJsonService() {
        MyJsonService myJsonService = new MyJsonService();
        myJsonService.setPrefixName(myJsonProperties.getPrefixName());
        myJsonService.setSuffixName(myJsonProperties.getSuffixName());
        return myJsonService;
    }


}
