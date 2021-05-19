package com.springcloud.microservicecloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate提供了多种便捷访问远程Http服务的方法，
 * 是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集
 */
/**
 * RestTemplate提供了多种便捷访问远程Http服务的方法，
 * 是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集
 */
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced  //负载均衡，LoadBalanced注解放在restTemplate方法上了，实现负载均衡的效果
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
    //目的实现负载均衡：轮询算法
    /*

    @Bean
    public IRule myRule(){
        return new RoundRobinRule();
    }

    */
   
   @Bean
    public IRule myRule(){
        return new RandomRule();
    }


    /*
    @Bean
    public IRule myRule(){
        return new RetryRule();
        //目的实现负载均衡：RetryRule的算法，如果服务器全部正常，使用的是轮询算法，
        // 如果是有一台服务器不正常，在指定的时间内选择一个可用的服务器
    }*/
}