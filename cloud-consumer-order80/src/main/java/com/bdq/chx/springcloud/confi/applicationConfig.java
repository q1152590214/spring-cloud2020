package com.bdq.chx.springcloud.confi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;



@Configuration
public class applicationConfig {

    @Bean
//    @LoadBalanced //然后这个有负载均衡
    public RestTemplate getrestTemplate(){
        return new RestTemplate();
    }

}
