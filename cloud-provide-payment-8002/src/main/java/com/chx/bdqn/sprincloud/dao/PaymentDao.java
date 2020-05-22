package com.chx.bdqn.sprincloud.dao;


import com.bdqn.chx.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    public int add(Payment payment);

    public Payment getPaymentByid(@Param("id") int id);

}
