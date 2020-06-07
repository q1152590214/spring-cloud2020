package com.bdqn.chx.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.IllegalFormatCodePointException;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping(value = "/testa")
    public String testA(){
        return "------testA";
    }
    @GetMapping(value = "/testb")
    public String testB(){
        log.info(Thread.currentThread().getName()+"\t textb");
        return "------testB";
    }
    @GetMapping(value = "/testc")
    public String testc(){
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        }catch (Exception e){
//
//        }
//
//        log.info("testc :RT");
        log.info("tstc - 异常比例");
        int num=10/0;
        return "------testc";
    }


    @GetMapping(value = "/testd")
    @SentinelResource(value = "testd",blockHandler = "bakc_testd")
    public String testd(@RequestParam(value = "p1",required = false)String p1 ,
                        @RequestParam(value = "p2",required = false)String p2 ){
        return "--------testd Key热点限流";
    }

    //自己设定的兜底方案
    public String bakc_testd(String p1 , String p2 , BlockException exception){

        return "-------bakc_testd，o(╥﹏╥)o";
    }
}
