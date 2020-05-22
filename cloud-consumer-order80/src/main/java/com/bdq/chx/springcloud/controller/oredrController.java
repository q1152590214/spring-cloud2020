package com.bdq.chx.springcloud.controller;


import com.bdq.chx.springcloud.lb.LoadBalancer;
import com.bdqn.chx.entity.CommonResult;
import com.bdqn.chx.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class oredrController {


    public static  final  String PAYMENT_URL ="http://CLOUD-PROVUDE-SERVER";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    LoadBalancer loadBalancer;

    @Resource
    DiscoveryClient discoveryClient;


    @GetMapping("/consumer/payment/add")
    public CommonResult<Payment> paymentAdd(Payment payment){
        log.info("添加新的成员");
        return restTemplate.postForObject(PAYMENT_URL+"/payment/add",payment,CommonResult.class);
    }


    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") int id){
         log.info("消费者查询");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("consumer/payment/getentity/{id}")
    public CommonResult<Payment> getPaymentByid2(@PathVariable("id") int id){

        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            log.info(entity.getStatusCode()+"\t" +entity.getHeaders());
            return  entity.getBody();
        }else{
            return new CommonResult<>(444,"操作失败");
        }

    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PROVUDE-SERVER");
        if (serviceInstances == null && serviceInstances.size()<=0){
                return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instance(serviceInstances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);


    }


}
