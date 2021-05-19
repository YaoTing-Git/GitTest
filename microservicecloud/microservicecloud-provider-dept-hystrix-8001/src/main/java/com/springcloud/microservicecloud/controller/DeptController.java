package com.springcloud.microservicecloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.microservicecloud.pojo.Dept;
import com.springcloud.microservicecloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @PostMapping("/dept/add")
    public Boolean addDept(@RequestBody Dept dept){
        return  deptService.addDept(dept);
    }


    @GetMapping("/dept/list")
    /*@HystrixCommand(fallbackMethod = "processHystrix_Get",
            commandProperties = {
                    //信号量策略
                    @HystrixProperty(name="execution.isolation.strategy",value = "SEMAPHORE"),
                    //默认值是10，前提是SEMAPHORE信号量隔离
                    @HystrixProperty(name="execution.isolation.semaphore.maxConcurrentRequests",value ="1" )
            }
    )*/
    public List<Dept> getAllDepts(){
        return  deptService.getAllDepts();
    }


    /**
     * 根据ID查询部门信息
     * 如果访问失败，启动备选方案
     * 1.导入Hystrix依赖
     * 2.在方法上进行添加注解:HystrixCommand注解，fallbackMethod属性代表的是备选方法的方法名称
     * 3.在主启动上添加注解
     * 如果访问成功，直接显示部门信息
     *
     *
     */
    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "processHystrix_Get",
            commandKey = "getDeptById",
            groupKey = "PRIVATE",
            commandProperties = {
                    //执行线程池隔离策略
                    @HystrixProperty(name="execution.isolation.strategy",value = "THREAD")
            },//如果是同一个线程池必须和groupKey保持一致，如果不是将不能保持一致
            threadPoolKey = "PRIVATE",
            threadPoolProperties = {
                    //线程池的大小
                    @HystrixProperty(name="coreSize",value = "20"),
                    //最大队列长度
                    @HystrixProperty(name="maxQueueSize",value = "10"),
                    //线程存活时间
                    @HystrixProperty(name="keepAliveTimeMinutes",value = "2"),
                    //拒绝请求
                    @HystrixProperty(name="queueSizeRejectionThreshold",value = "10")
            }
    )
    public Dept getDeptById(@PathVariable(value = "id") Long deptNo){
        Dept dept = deptService.getDeptById(deptNo);
        if(dept==null){
            throw  new RuntimeException("该ID："+deptNo+"没有对应的信息");
        }
        return dept;
    }
    //备选方案的方法
    public Dept processHystrix_Get(@PathVariable(value = "id") Long deptNo){
        return new Dept()
                .setDeptno(deptNo)
                .setDeptname("该ID："+deptNo+"没有对应的信息，null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }



    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        System.out.println("**********" + list);
        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for(ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri()); }
        return this.discoveryClient;
    }
}
