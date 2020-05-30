package com.bdqn.chx.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import sun.tools.jar.Main;

@Component
@EnableBinding(Sink.class)
public class StreamEassageController {
    @Value("${server.port}")
    private  String port;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){

        System.out.println("消费者2号------>消息内容"+ message.getPayload()+"\t port:"+port);

    }
}
