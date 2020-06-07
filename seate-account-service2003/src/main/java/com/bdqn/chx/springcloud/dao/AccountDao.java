package com.bdqn.chx.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface AccountDao {

    void descrease(@Param("userId") int userId,@Param("money") int money);

}
