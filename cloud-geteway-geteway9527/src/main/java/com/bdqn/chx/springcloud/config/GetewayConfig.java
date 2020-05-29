package com.bdqn.chx.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetewayConfig {


    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        // path_rotel1对应配置文件的ID /guonei 为单前9527/guonei这个地址映射为http://www.hao123.com
        routes.route("path_rote1",r -> r.path("/guonei").uri("https://www.hao123.com"));
        return routes.build();
    }
}
