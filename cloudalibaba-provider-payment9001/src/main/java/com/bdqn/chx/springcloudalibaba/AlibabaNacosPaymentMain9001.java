package com.bdqn.chx.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaNacosPaymentMain9001 {

    public static void main(String[] args) {
        SpringApplication.run( AlibabaNacosPaymentMain9001.class,args);
    }
}
