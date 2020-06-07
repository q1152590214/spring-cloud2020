package com.bdqn.chx.springcloud.controller;

import com.bdqn.chx.entity.CommonResult;
import com.bdqn.chx.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Slf4j
public class PaymentController {

    private  static HashMap<Integer, Payment> hashMap;

    @Value("${server.port}")
    private  String serverPort;

    static {
        hashMap = new HashMap<>();
        hashMap.put(new Integer(1),new Payment(1,"旺仔"));
        hashMap.put(new Integer(2),new Payment(2,"柠檬茶"));
        hashMap.put(new Integer(3),new Payment(3,"豆奶"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> getPayent(@PathVariable("id") int id){
        Payment payment = hashMap.get(id);
        return  new CommonResult(200,"form mysql serverPort: \t"+serverPort,payment);
    }
}
