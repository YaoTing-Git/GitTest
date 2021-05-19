package com.springcloud.microservicecloud.controller;

import com.springcloud.microservicecloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {
    //private static final String URL="http://localhost:8001";
    private static final String URL="http://MICROSERVICECLOUD-DEPT";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public Boolean addDept(Dept dept){
        //URL:提供者的请求地址，请求参数，HTTP相应被转换成的对象类型(这个方法的返回值类型)
        return  restTemplate.postForObject(URL+"/dept/add",dept,Boolean.class);
    }
    @GetMapping(value = "/consumer/dept/list")
    public List<Dept> getAllDepts(){
        //URL:提供者的请求地址，请求参数，HTTP相应被转换成的对象类型(这个方法的返回值类型)
        return  restTemplate.getForObject(URL+"/dept/list",List.class);
    }
    @GetMapping(value = "/consumer/dept/get/{id}")
    public Dept getDeptById(@PathVariable("id") Long deptNo){
        //URL:提供者的请求地址，请求参数，HTTP相应被转换成的对象类型(这个方法的返回值类型)
        return  restTemplate.getForObject(URL+"/dept/get/"+deptNo,Dept.class);
    }

    //服务之间的调用：获取服务发现的信息
    @RequestMapping("/consumer/dept/discovery")
    public Object discovery(){
        //return restTemplate.getObject(url:URL+"/"
        return  restTemplate.getForObject(URL+"/dept/discovery",Object.class);
    }
}
