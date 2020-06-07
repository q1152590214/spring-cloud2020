package com.bdqn.chx.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaNacosPaymentMain9002 {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosPaymentMain9002.class,args);
    }
}
