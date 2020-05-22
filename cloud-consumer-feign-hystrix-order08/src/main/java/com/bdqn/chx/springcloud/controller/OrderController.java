package com.bdqn.chx.springcloud.controller;

import com.bdqn.chx.springcloud.serivce.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfo_TimeOutHandlerDefault")
public class OrderController {

    @Resource
    private  PaymentHystrixService  paymentHystrixService;

//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500"))
    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") int id){
//        int num = 10/0;
        String result = paymentHystrixService.paymentInfo_OK(id);
        return  result;
    }

//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500"))
    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") int id){
        int num  = 10/0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentInfo_TimeOutHandler(@PathVariable("id") int  id){
        return  "80  线程池："+Thread.currentThread().getName()+"系统繁忙，请稍后在试"+" ┭┮﹏┭┮";
    }

    public String paymentInfo_TimeOutHandlerDefault(){
        return "默认处理方法 o(*￣︶￣*)o";
    }








}
