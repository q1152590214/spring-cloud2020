package com.bdqn.chx.springcloud.service;

import com.bdqn.chx.entity.CommonResult;
import com.bdqn.chx.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-PROVUDE-SERVER")
@Component
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") int id);

    @GetMapping(value = "/payment/feign/timeout")
    public String PaymentFeignTimeOut();
}
