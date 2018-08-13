package com.example.srpingboot.Mapper;

import com.example.srpingboot.bean.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EmployeeXmlMapper {

    public Employee getEmpById(Integer id);

    public int insertEmp(Employee employee);
}
