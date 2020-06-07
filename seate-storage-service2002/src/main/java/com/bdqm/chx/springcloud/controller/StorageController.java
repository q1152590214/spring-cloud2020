package com.bdqm.chx.springcloud.controller;

import com.bdqm.chx.springcloud.domain.commonResult;
import com.bdqm.chx.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class StorageController {

    @Resource
    StorageService storageService;

    @RequestMapping("/storage/decrease")
    commonResult decrease(@RequestParam("productId")int productId,@RequestParam("count")int count){
        storageService.decreate(productId,count);
        return new commonResult(200,"修改成功");

    }
}
