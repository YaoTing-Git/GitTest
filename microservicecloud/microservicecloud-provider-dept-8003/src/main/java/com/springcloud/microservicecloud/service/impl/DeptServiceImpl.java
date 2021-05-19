package com.springcloud.microservicecloud.service.impl;

import com.springcloud.microservicecloud.mapper.DeptMapper;
import com.springcloud.microservicecloud.pojo.Dept;
import com.springcloud.microservicecloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> getAllDepts() {
        return deptMapper.getAllDepts();
    }

    @Override
    public Dept getDeptById(Long deptNo) {
        return deptMapper.getDeptById(deptNo);
    }

    @Override
    public Boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }
}
