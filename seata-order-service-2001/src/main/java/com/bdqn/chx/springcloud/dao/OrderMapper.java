package com.bdqn.chx.springcloud.dao;

import com.bdqn.chx.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    void create(Order order);

    void update(@Param("userId") int userId, @Param("status") int status);
}

