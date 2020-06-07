package com.bdqn.chx.springcloud.service.impl;

import com.bdqn.chx.springcloud.dao.OrderMapper;
import com.bdqn.chx.springcloud.domain.Order;
import com.bdqn.chx.springcloud.service.AccountService;
import com.bdqn.chx.springcloud.service.OrderService;
import com.bdqn.chx.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderMapper orderMapper;

    @Resource
    AccountService accountService;

    @Resource
    StorageService storageService;

    @Override
    @GlobalTransactional(name = "cloud_tx_group",rollbackFor = Exception.class)
    public void creata(Order order) {
        log.info("创建订单====================");
        //1增加一个新的订单
            orderMapper.create(order);
        log.info("订单微服务调用库存，开始扣减=================");
        //2扣减库存
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("订单微服务开调用库存进行扣减end==================");

        log.info("订单微服务开调用户,进行扣减money====================");
        //3扣减用户金额
        accountService.decrease(order.getUserId(),order.getMoney());

        log.info("订单微服务开始修改订单状态================");
        //4修改订单状态
        orderMapper.update(order.getUserId(),0);

        log.info("下订单结束，O(∩_∩)O哈哈~");
    }
}
