package com.bdqn.chx.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bdqn.chx.entity.CommonResult;
import com.bdqn.chx.entity.Payment;
import com.bdqn.chx.springcloud.MyHandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLImitController {

    @GetMapping(value = "/BuResource")
    @SentinelResource(value = "BuResource",blockHandler = "handelException")
    public CommonResult ByResource(){

        return  new CommonResult(200,"按照资源名称限流测试",new Payment(2020,"serial1001"));
    }


    public CommonResult handelException(BlockException e){
        return new CommonResult(444, e.getClass().getCanonicalName()+"\t 服务不可用");
    }


    @GetMapping(value ="/rateLimit/BuUrl")
    @SentinelResource(value ="BuUrl" )
    public CommonResult byUrl(){
        return new CommonResult(200, "按URL测试限流OK",new Payment(2020,"serial1002"));
    }

    @GetMapping(value = "/rateLimit/customerBlockhoandler")
    @SentinelResource(value = "customerBlockhoandler",blockHandlerClass =CustomerBlockHandler.class,blockHandler = "commonResult1")
    public  CommonResult customerBlockhoandler(){
        return  new CommonResult(200,"用户自定义限流OK",new Payment(2020,"eserial1003"));
    }
}
