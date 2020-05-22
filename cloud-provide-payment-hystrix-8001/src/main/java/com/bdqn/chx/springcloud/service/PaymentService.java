package com.bdqn.chx.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo_OK(int id){
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_OK  " +id+" O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",
            commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    public String paymentInfo_TimeOut(int id){
        int timeout = 3;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeOut  " +id+"Ծ‸Ծ    耗时:";
    }

    public String paymentInfo_TimeOutHandler(int id){
        String result = "线程池："+Thread.currentThread().getName()+"系统繁忙，请稍后在试"+" ┭┮﹏┭┮";
        return result;
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "pyamentCircuitBreaker_fallback", commandProperties =
            {@HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开始断路器
                    @HystrixProperty(name ="circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
                    @HystrixProperty(name ="circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期 就是在多少时间内
                    @HystrixProperty(name ="circuitBreaker.errorThresholdPercentage", value = "60") //失败率到达多少后跳闸
            })

    public String pyamentCircuitBreaker(int id){
        if(id<0){
            throw  new RuntimeException("**********id不能为负数");
        }
        String word = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t "+"调用成功,流水号"+word;
    }

    public String pyamentCircuitBreaker_fallback(@PathVariable("id") int id){
        return  "id不能为负数请稍后在试 o(╥﹏╥)o id:"+id;
    }
}
