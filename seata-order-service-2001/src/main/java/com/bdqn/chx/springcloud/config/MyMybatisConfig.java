package com.bdqn.chx.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.bdqn.chx.springcloud.dao")
public class MyMybatisConfig {
}
