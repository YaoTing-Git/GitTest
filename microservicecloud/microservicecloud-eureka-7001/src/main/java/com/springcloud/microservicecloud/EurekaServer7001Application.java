package com.springcloud.microservicecloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
    @SpringBootApplication
    @EnableEurekaServer //代表的是EurekaServer 服务类的启动类，可以接受其他的微服务注册进来
    public class EurekaServer7001Application {
        public static void main(String[] args) {
            SpringApplication.run(EurekaServer7001Application.class,args);
        }
    }
