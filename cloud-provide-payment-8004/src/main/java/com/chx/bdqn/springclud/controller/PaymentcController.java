package com.chx.bdqn.springclud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentcController {

    @Value("${server.port}")
    String port;


    @RequestMapping("payment/zk")
    public String paymentzk(){
        return "springcloud with zk :"+port+"\t"+ UUID.randomUUID().toString();

    }
}
