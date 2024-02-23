package com.nhnacademy.mini.dooray.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "account.api")
public class AccountRequestUrl {
    private String server;
    private int port;

    public String get(){
        return "http://"+server + ":" + port;
    }
}
