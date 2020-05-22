package com.chx.bdqn.sprincloud.service;

import com.bdqn.chx.entity.Payment;
import com.chx.bdqn.sprincloud.dao.PaymentDao;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class paymentServerimpl implements  paymentService {

    @Resource
    PaymentDao paymentDao;



    @Override
    public int add(Payment paymeny) {
        return paymentDao.add(paymeny);
    }

    @Override
    public Payment getPaymentByid(int id) {
        return paymentDao.getPaymentByid(id);
    }
}
