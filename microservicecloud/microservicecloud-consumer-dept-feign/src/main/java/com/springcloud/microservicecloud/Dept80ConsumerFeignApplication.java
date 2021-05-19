package com.springcloud.microservicecloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient  //将服务注册到注册中心中
@EnableFeignClients(basePackages ="com.springcloud.microservicecloud")
public class Dept80ConsumerFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(Dept80ConsumerFeignApplication.class,args);
    }
}
