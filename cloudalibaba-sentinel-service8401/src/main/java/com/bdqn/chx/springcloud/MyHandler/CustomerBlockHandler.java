package com.bdqn.chx.springcloud.MyHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bdqn.chx.entity.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult commonResult1(BlockException exception){
        return  new CommonResult(444,"CustomerBlockHandler/commonResult--------1 方法┭┮﹏┭┮");
    }
    public static CommonResult commonResult2(BlockException exception){
        return  new CommonResult(444,"CustomerBlockHandler/commonResult--------2 方法┭┮﹏┭┮");
    }
}
