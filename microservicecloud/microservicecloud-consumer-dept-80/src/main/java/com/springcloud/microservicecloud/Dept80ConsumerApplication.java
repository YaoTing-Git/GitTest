package com.springcloud.microservicecloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //代表将消费者服务注册注册中心中
public class Dept80ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(Dept80ConsumerApplication.class,args);
    }
}
