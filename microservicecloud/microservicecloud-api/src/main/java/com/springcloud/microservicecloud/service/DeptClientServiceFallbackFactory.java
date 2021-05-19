package com.springcloud.microservicecloud.service;

import com.springcloud.microservicecloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *DeptClientServiceFallbackFactory实现了FallbackFactory接口
 * 重写create方法
 *所有的熔断机制都存放在这个类中
 *
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            //根据id查询部门信息
            @Override
            public Dept get(Long deptNo) {
                return  new Dept()
                        .setDeptno(deptNo)
                        .setDeptname("该ID："+deptNo+"没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
                        .setDb_source("no this database in MySQL");
            }
            //查询部门的所有的信息
            @Override
            public List<Dept> getDept() {
                return null;
            }
            //添加部门信息
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
