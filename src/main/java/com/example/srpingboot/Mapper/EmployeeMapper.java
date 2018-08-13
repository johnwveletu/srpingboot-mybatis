package com.example.srpingboot.Mapper;


import com.example.srpingboot.bean.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

//@Mapper
@Repository
public interface EmployeeMapper {

    @Select("select * from mybatis_employee where id=#{id}")
    public Employee getEmpById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into mybatis_employee (last_name,email,d_id) values(#{lastName},#{email},#{department.id})")
    public int insertEmp(Employee employee);

}
