package com.bdqm.chx.springcloud.service;


import org.apache.ibatis.annotations.Param;

public interface StorageService {

    void decreate(int productId, int count);
}
