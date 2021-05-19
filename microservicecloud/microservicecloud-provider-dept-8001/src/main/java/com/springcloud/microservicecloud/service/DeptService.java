package com.springcloud.microservicecloud.service;

import com.springcloud.microservicecloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> getAllDepts();
    public Dept getDeptById(Long deptNo);
    public Boolean addDept(Dept dept);
}
