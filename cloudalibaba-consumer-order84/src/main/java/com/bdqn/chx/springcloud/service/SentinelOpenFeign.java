package com.bdqn.chx.springcloud.service;

import com.bdqn.chx.entity.CommonResult;
import com.bdqn.chx.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = SentinelOpenFeignImpl.class)
public interface SentinelOpenFeign {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> getPayent(@PathVariable("id") int id);
}
