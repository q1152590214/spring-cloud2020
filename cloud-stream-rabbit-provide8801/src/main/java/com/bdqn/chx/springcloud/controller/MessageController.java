package com.bdqn.chx.springcloud.controller;

import com.bdqn.chx.springcloud.service.MessageProvide;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessageController {

    @Resource
    MessageProvide messageProvide;


    @GetMapping(value = "/message")
    public String getMessage(){
      return   messageProvide.send();
    }
}
