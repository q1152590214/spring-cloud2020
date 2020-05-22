package com.bdq.chx.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.ServerIntrospector;
import org.springframework.stereotype.Component;

import java.util.List;


public interface LoadBalancer {

    ServiceInstance instance (List<ServiceInstance> serviceInstances);
}
