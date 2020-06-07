package com.bdqn.chx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SeateAccountServiceMain2003 {

    public static void main(String[] args) {
        SpringApplication.run(SeateAccountServiceMain2003.class,args);
    }
}
