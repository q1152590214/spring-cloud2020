package com.bdqn.chx.springcloud.service;


import com.bdqn.chx.springcloud.domain.commonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-account-service")
public interface AccountService {


    @PostMapping("/account/decrease")
    commonResult decrease(@RequestParam("userId") int userId,@RequestParam("money") double money);
}
