package com.bdqn.chx.springcloud.service;


import com.bdqn.chx.springcloud.domain.commonResult;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seate-storage-service")
public interface StorageService {

    @PostMapping("/storage/decrease")
    commonResult decrease(@RequestParam("productId")int productId,@RequestParam("count")int count);
}
