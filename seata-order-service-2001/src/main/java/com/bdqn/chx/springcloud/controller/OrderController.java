package com.bdqn.chx.springcloud.controller;

import com.bdqn.chx.springcloud.dao.OrderMapper;
import com.bdqn.chx.springcloud.domain.Order;
import com.bdqn.chx.springcloud.domain.commonResult;
import com.bdqn.chx.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    OrderService orderService;

    @GetMapping("/order/create")
    public commonResult create(Order order){
        orderService.creata(order);
        return new commonResult(200,"创建订单成功");
    }
}
