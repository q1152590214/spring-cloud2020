package com.bdqn.chx.springcloud.service.impl;

import com.bdqn.chx.springcloud.service.MessageProvide;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)//创建一个消息管道
@Slf4j
public class MessgaeProvideImpl implements MessageProvide {


    @Resource
    MessageChannel output;  //向管道发送信息

    @Override
    public String send() {

        String word = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(word).build()); //消息生产者发的是Message 那么消息消费者也要收Message 传的参数为string 那么接受也要为string
        log.info("***********word = "+word);
        return  null;
    }
}
