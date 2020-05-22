package com.chx.bdqn.sprincloud.controller;
import com.bdqn.chx.entity.CommonResult;
import com.bdqn.chx.entity.Payment;
import com.chx.bdqn.sprincloud.service.paymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    paymentService paymentService;

    @Value("${server.port}")
    private  String post;

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

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return  post;
    }
}
