package com.bdqn.chx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaNacosDiscoveryMain9004 {


    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosDiscoveryMain9004.class,args);
    }
}
