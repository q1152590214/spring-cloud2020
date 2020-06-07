package com.bdqm.chx.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {

    void decreate(@Param("productId")int productId,@Param("count")int count);
}
