package com.example.srpingboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//用此注解可以省略每个Mapper中的@Mapper注解
@MapperScan(value = "com.example.srpingboot.Mapper")
@SpringBootApplication
public class SrpingbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SrpingbootMybatisApplication.class, args);
    }
}
