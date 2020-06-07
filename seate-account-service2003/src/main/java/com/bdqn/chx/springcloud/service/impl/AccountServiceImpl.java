package com.bdqn.chx.springcloud.service.impl;

import com.bdqn.chx.springcloud.dao.AccountDao;
import com.bdqn.chx.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountDao accountDao;

    @Override
    public void descrease(int userId, int money) {
        log.info("修改用户金额开始扣款=============");
        //模拟超时异常，全局事务回滚
        try {
            TimeUnit.SECONDS.sleep(20);
        }catch (Exception e){
            e.printStackTrace();
        }
        accountDao.descrease(userId,money);

        log.info("修改用户金额开始扣款============完成 ");
    }
}
