package com.pers.test;

import com.pers.bean.Department;
import com.pers.bean.Employee;
import com.pers.dao.DepartmentMapper;
import com.pers.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;
// *推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
// *1、导入SpringTest模块
// *2、@ContextConfiguration指定Spring配置文件的位置
// *3、直接autowired要使用的组件即可
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTestTest {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void testCurd() {
        //原生
        //1.创建SpringIOC容器
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.从容器中获取mapper
//        DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
        System.out.println("====departmentMapper=" + departmentMapper);
        //1.插入部门
        //departmentMapper.insertSelective(new Department(null,"开发部"));
        //departmentMapper.insertSelective(new Department(null,"测试部"));

        //2.生成员工
        //employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@test.com",1));

        //3.批量插入
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString().substring(0,5) + i;
            mapper.insertSelective(new Employee(null,uuid,"M",uuid+"@test.com",1));
        }
        System.out.println("批量完成");
    }
}