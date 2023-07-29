package com.github.mrs.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * date: 2023/7/29 14:07
 * author: MR.孙
 */
@Component
public class HttpUserVO {

    @Value("${server.port}")
    private Integer port;

    @Value("${type}")
    private String typeName;

    @Value("${host}")
    private String host;

    public String sweepHost() {
        return this.typeName + this.host + ":" + this.port;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }


}
