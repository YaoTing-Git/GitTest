package com.springcloud.microservicecloud.service;

import com.springcloud.microservicecloud.pojo.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    @RequestMapping(value = "/dept/get/{id}")
    public Dept get(@PathVariable("id") Long deptNo);
    @RequestMapping(value = "/dept/list")
    public List<Dept> getDept();
    @RequestMapping(value = "/dept/add")
    public boolean addDept(Dept dept);
}