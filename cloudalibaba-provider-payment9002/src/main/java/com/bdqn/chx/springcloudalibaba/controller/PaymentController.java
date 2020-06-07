package com.bdqn.chx.springcloudalibaba.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    String  port;

    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") int id){
        return "nacos registry, port:"+port;
    }
}
