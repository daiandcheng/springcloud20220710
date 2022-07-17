package com.edu.springcloud.config;

import com.edu.springcloud.component.RoundRobinLoadBalancer_ZY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

//@Configuration
public class MyLoadBalancer {
    @Autowired
    private DiscoveryClient discoveryClient ;
    /**
     * ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider,
     * 			String serviceId
     * @return
     */
    @Bean
    public ReactorServiceInstanceLoadBalancer reactorServiceInstanceLoadBalancer(Environment environment,LoadBalancerClientFactory loadBalancerClientFactory) {
        String serviceId =environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        System.out.println(serviceId);
//        return new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(serviceId,ServiceInstanceListSupplier.class), serviceId);
        return new RoundRobinLoadBalancer_ZY(loadBalancerClientFactory.getLazyProvider(serviceId,ServiceInstanceListSupplier.class),serviceId) ;
    }
}
