package com.bdqm.chx.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.bdqm.chx.springcloud.dao")
public class MyMybatisConfig {


}
