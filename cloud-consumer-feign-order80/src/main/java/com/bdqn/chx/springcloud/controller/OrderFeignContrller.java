package com.bdqn.chx.springcloud.controller;

import com.bdqn.chx.entity.CommonResult;
import com.bdqn.chx.entity.Payment;
import com.bdqn.chx.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignContrller {

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping(value = "/comsumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") int  id){

        return  paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String PaymentFeignTimeOut(){
        return paymentFeignService.PaymentFeignTimeOut();
    }
}
