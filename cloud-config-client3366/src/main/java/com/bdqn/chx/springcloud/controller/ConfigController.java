package com.bdqn.chx.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope
public class ConfigController {


    @Value("${server.port}")
    private  String port;

    @Value("${config.info}")
    private  String info;


    @GetMapping("/getconfig")
    public String getconfig(){

        return "port:"+port+"\n"+info;
    }
}
