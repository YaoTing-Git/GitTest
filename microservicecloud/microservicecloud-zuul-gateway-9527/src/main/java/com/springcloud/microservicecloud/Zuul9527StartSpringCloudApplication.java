package com.springcloud.microservicecloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //开启网关代理
public class Zuul9527StartSpringCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(Zuul9527StartSpringCloudApplication.class,args);
    }
}
