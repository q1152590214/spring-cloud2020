package com.bdqn.chx.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.bdqn.chx.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.StringHolder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeoutException;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") int id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("==================result:"+result);

        return result;

    }


    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") int id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("==================result:"+result);

        return result;

    }

    @GetMapping("/payment/cricuti/{id}")
    public String paymentCiruitBreaker(@PathVariable("id") int id){
        String result = paymentService.pyamentCircuitBreaker(id);
        log.info("*****************result:"+result);


        return result;

    }


}
