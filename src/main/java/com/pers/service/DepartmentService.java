package com.pers.service;

import com.pers.bean.Department;
import com.pers.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DepartmentService
 * @Description //TODO
 * @Author LiuRan
 * @Date 2020/7/23 14:24
 * @Version 1.0
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;


    public List<Department> getDepts() {
        List<Department> list = departmentMapper.selectByExample(null);
        return list;
    }
}
