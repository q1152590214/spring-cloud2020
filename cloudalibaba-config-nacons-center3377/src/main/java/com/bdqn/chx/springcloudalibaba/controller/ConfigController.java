package com.bdqn.chx.springcloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //支持Nacos动态刷新
public class ConfigController {

    @Value("${config.info}")
    private  String info;


    @GetMapping("/config/info")
    public String getInfo(){
        return info;
    }
}
