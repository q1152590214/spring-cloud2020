package com.bdqn.chx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaNacosDiscoveryMain9003 {


    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosDiscoveryMain9003.class,args);
    }
}
