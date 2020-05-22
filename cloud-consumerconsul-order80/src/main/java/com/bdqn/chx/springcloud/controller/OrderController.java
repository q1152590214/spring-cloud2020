package com.bdqn.chx.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Value("${server.port}")
    private String port;

    @Resource
    RestTemplate restTemplate;

    public final  String URL = "http://cloud-provide-paymentconsul/";

    @GetMapping(value ="consumer/payment/consul")
    public String ordercontroller(){

        String s = restTemplate.getForObject(URL+"payment/consul",String.class);
        return s;
    }

}
