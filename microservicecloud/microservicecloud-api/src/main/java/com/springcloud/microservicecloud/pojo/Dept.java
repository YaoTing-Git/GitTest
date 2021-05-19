package com.springcloud.microservicecloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 解决：每次都会去修改实体类的问题：setter,getter,构造方法，toString方法
 * 1.添加依赖
 * 2.添加插件
 * 3.添加注解
 */
@SuppressWarnings("Serial")
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {
	private Long deptno;
	private String deptname;
	private String db_source;

//	public static void main(String[] args) {
//		Dept dept=new Dept();
//		dept.setDb_source("cloudb01");
//		dept.setDeptno(1111L);
//		dept.setDeptname("张三");
//		System.out.println(dept.toString());
//	}
}
