package com.example.srpingboot.controller;

import com.example.srpingboot.Mapper.EmployeeMapper;
import com.example.srpingboot.Mapper.EmployeeXmlMapper;
import com.example.srpingboot.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeXmlMapper employeeXmlMapper;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from mybatis_employee");
        return list.toString();
    }

    @ResponseBody
    @RequestMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id){
        //Employee emp = employeeMapper.getEmpById(id);
        Employee emp = employeeXmlMapper.getEmpById(id);
        return emp;
    }

    @ResponseBody
    @RequestMapping("/emp")
    public Employee insertEmp(Employee employee){
        //employeeMapper.insertEmp(employee);
        employeeXmlMapper.insertEmp(employee);
        return employee;
    }

}
