package com.bdqn.chx.springcloud.serivce;

import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(int id) {
        return "==============8001宕机了 ┭┮﹏┭┮ paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(int id) {
        return "==============8001宕机了 ┭┮﹏┭┮ paymentInfo_TimeOut";
    }
}
