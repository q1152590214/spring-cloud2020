package com.bdqn.chx.springcloud.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
@Slf4j
public class OrderZKController {


    @Value("${server.port}")
    private  String port;

    public static final String  URL ="http://cloud-provide-payment";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping(value = "/consumer/payment/zk")
    public  String paymentingfo(){
        String  result= restTemplate.getForObject(URL+"/payment/zk",String.class);
        return  result;
    }


}
