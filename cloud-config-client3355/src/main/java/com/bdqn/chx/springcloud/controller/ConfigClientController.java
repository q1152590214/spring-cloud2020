package com.bdqn.chx.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@RestController
@Slf4j
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    String info;

    @GetMapping("/getconfiginfo")
    public  String getConfigInfo(){

        return info;
    }


}
