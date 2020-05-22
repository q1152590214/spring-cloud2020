package com.bdq.chx.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLb implements LoadBalancer{

    /**
     * 原子整型
     */
    AtomicInteger atomicInteger = new AtomicInteger(0);


    /**
     * 用自旋锁计算出每次轮询的下标
     * @return
     */
    public final  int getAndIncrement(){
        int corrent;
        int next;
        //自旋锁
        do {
            corrent = atomicInteger.get();
            next = corrent>=Integer.MAX_VALUE? 0 : corrent+1;
        }while (!this.atomicInteger.compareAndSet(corrent,next));
        System.out.println("next======第几次访问："+next);
        return  next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}
