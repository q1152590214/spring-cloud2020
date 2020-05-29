package com.bdqn.chx.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
@Slf4j
public class MyLogGatweayFilter  implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("************************* come in MyLogGatweayFilter"+new Date());
        //要求http请求要带上uname
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname==null){
            log.info("******用户名为空，非法用户┭┮﹏┭┮");
            //给对方一个回应，设置状态码
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();    

        }
        return chain.filter(exchange);
    }


    /**
     * 过滤器的加载顺序
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
