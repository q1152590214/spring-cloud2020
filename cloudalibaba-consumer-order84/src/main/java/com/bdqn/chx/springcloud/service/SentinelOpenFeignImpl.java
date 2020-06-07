package com.bdqn.chx.springcloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.bdqn.chx.entity.CommonResult;
import com.bdqn.chx.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class SentinelOpenFeignImpl implements SentinelOpenFeign {
    @Override
    public CommonResult<Payment> getPayent(int id) {
        return new CommonResult<Payment>(444,"openfeign默认服务降级",new Payment(id,null));
    }
}
