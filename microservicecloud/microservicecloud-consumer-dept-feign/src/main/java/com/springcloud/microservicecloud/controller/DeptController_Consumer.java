package com.springcloud.microservicecloud.controller;

import com.springcloud.microservicecloud.pojo.Dept;
import com.springcloud.microservicecloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class DeptController_Consumer {
    @Autowired
    private DeptClientService deptClientService;
    @RequestMapping(value = "/consumer/dept/add")
    public Boolean add(Dept dept){
        return deptClientService.addDept(dept);
    }
    @GetMapping(value = "/consumer/dept/list")
    public List<Dept> getDeptList(){
        return deptClientService.getDept();
    }
    @GetMapping(value = "/consumer/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Long deptNo){
        return deptClientService.get(deptNo);
    }


}
