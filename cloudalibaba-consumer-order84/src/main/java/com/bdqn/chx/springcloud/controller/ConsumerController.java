package com.bdqn.chx.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bdqn.chx.entity.CommonResult;
import com.bdqn.chx.entity.Payment;
import com.bdqn.chx.springcloud.service.SentinelOpenFeign;
import com.sun.deploy.security.BlockedDialog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ConsumerController {


   // @Value("${service-url.nacos-user-servic}")
    private  static  String SERVER_URL ="http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private SentinelOpenFeign sentinelOpenFeign;


    @GetMapping(value = "/consumer/fallback/{id}")
   // @SentinelResource(value ="fallback" ,fallback = "handlerFallBack")
   // @SentinelResource(value = "fallback",blockHandler = "blockHandler")
    @SentinelResource(value = "fallback",blockHandler = "blockHandler" ,fallback = "handlerFallBack",exceptionsToTrace = {IllegalArgumentException.class})
    public CommonResult<Payment> getPayment(@PathVariable("id") int id){
       CommonResult<Payment> forObject = restTemplate.getForObject(SERVER_URL+"/paymentSQL/"+id, CommonResult.class,id);
       if(id==4){
           throw new IllegalArgumentException("IllegalAccessException,非法参数异常");
       }else if(forObject.getData()==null){
           throw new NullPointerException("NullPointerException,没有ID对应的记录，空指针异常");
       }
        return forObject;
    }

    //只配fallback
    public CommonResult<Payment> handlerFallBack(@PathVariable("id") int id,Throwable throwable){
        Payment payment = new Payment(id,null);
        return new CommonResult<Payment>(444,"兜底异常handlerFallBack,exception内容:"+throwable.getMessage(),payment);

    }

    //blockhanlder
    public CommonResult blockHandler(@PathVariable("id") int id, BlockException e){
        return new CommonResult(444,"sentinel限流，exception信息："+e.getMessage(),new Payment(id,null));
    }

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult paymentSQL(@PathVariable("id") int id){

        return sentinelOpenFeign.getPayent(id);
    }
}
