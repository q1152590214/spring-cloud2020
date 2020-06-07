package com.bdqn.chx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class AlibabaNacosOrderMain84 {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosOrderMain84.class,args);
    }
}
