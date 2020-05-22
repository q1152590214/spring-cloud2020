package com.chx.bdqn.sprincloud.service;


import com.bdqn.chx.entity.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface paymentService {

    public int add(Payment paymeny);

    public Payment getPaymentByid(@Param("id") int  id);
}
