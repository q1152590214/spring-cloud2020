package com.bdqn.chx.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import sun.tools.jar.Main;

@Component
@Slf4j
@EnableBinding(Sink.class)
public class ReceiverMessageController {

    @Value("${server.port}")
    String port;

    @StreamListener(Sink.INPUT)//监听
    public void  input(Message<String> message){
        System.out.println("消费者1号，---------->我们收到的消息"+message.getPayload()+"/t port:"+port);
    }

}
