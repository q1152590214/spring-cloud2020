package com.chx.bdqn.sprincloud.controller;
import com.bdqn.chx.entity.CommonResult;
import com.bdqn.chx.entity.Payment;
import com.chx.bdqn.sprincloud.service.paymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.rcache.AuthTime;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    paymentService paymentService;

    @Value("${server.port}")
    private String post;

    @Resource
    DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/add")
    public CommonResult add(@RequestBody Payment payment){
        int result = paymentService.add(payment);

        log.info("****插入结果："+result);
        if(result>0){
            return new CommonResult(200,"插入数据库成功,post"+post,result);
        }else {
            return  new CommonResult(444,"插入数据失败",null);
        }

    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") int id){
        Payment payment = paymentService.getPaymentByid(id);
        log.info("*****查询结果"+payment);
        if(payment !=null){
            log.info("1");
                return  new CommonResult(200,"查询数据成功,post"+post,payment);
        }else{
            log.info("2");
            return  new CommonResult(444,"查询失败没有对应记录："+id,null);

        }

    }


    /**
     * 用discveryClient获取相关服务信息
     * @return
     */
    @GetMapping("/payment/discovery")
    public Object getDiscoveryClient(){

        List<String> services = discoveryClient.getServices();
        for (String s : services){
            log.info(s);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVUDE-SERVER");

        for (ServiceInstance  serviceInstance:instances){
            log.info(serviceInstance.getServiceId()+"/t" + serviceInstance.getHost() +"/t"+serviceInstance.getPort()+"/t"+serviceInstance.getUri());

        }


        return discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return  post;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String PaymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }

        return  post;

    }


}
