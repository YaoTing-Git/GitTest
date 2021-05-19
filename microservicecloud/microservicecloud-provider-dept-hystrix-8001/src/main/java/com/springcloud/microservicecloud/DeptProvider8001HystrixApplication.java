package com.springcloud.microservicecloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //开启熔断器的支持
public class DeptProvider8001HystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001HystrixApplication.class,args);
    }
}
