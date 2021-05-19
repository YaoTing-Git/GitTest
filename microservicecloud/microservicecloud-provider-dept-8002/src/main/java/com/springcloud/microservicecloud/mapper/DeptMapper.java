package com.springcloud.microservicecloud.mapper;

import com.springcloud.microservicecloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    //查询
    public List<Dept> getAllDepts();
    //查询
    public Dept getDeptById(Long deptNo);
    //添加
    public boolean addDept(Dept dept);
    //修改
    //删除
    public int deleteDept(Long deptNo);
}
