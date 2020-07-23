package com.pers.controller;

import com.pers.bean.Department;
import com.pers.bean.Msg;
import com.pers.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName DeptController
 * @Description 处理部门有关请求
 * @Author LiuRan
 * @Date 2020/7/23 14:22
 * @Version 1.0
 */
@Controller
public class DeptController {
    @Autowired
    private DepartmentService departmentService;

    //返回所有部门信息
    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts() {
        List<Department> list = departmentService.getDepts();
        return Msg.success().add("depts",list);
    }
}
