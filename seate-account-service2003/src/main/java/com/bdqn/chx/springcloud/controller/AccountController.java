package com.bdqn.chx.springcloud.controller;

import com.bdqn.chx.springcloud.doman.commonResult;
import com.bdqn.chx.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class AccountController {


    @Resource
    AccountService accountService;

    @RequestMapping("/account/decrease")
    commonResult decrease(@RequestParam("userId") int userId, @RequestParam("money") double money){
        accountService.descrease(userId,userId);
        return  new commonResult(200,"账号金额修改成功");
    }
}
