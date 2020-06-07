package com.bdqm.chx.springcloud.service.impl;

import com.bdqm.chx.springcloud.dao.StorageDao;
import com.bdqm.chx.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    StorageDao storageDao;

    @Override
    public void decreate(int productId, int count) {
        log.info("开始对库存进行修改==============");
        storageDao.decreate(productId,count);
        log.info("完成对库存进行修改==============");
    }
}
