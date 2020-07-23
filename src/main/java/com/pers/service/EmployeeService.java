package com.pers.service;

import com.pers.bean.Employee;
import com.pers.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EmployeeService
 * @Description //TODO
 * @Author LiuRan
 * @Date 2020/7/22 11:29
 * @Version 1.0
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    //查询所有员工
    public List<Employee> getAll() {
        List<Employee> list = employeeMapper.selectByExampleWithDept(null);
        return list;
    }


    public void saveEmp(Employee employee) {
        employeeMapper.insertSelective(employee);
    }
}
