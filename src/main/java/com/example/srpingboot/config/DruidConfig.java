package com.example.srpingboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置Druid
 */
@Configuration
public class DruidConfig {

    /**
     * 配置druid数据源，让其在配置文件中的配置生效
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    //配置druid监控
    //配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> map = new HashMap<>();
        map.put("loginUsername","admin");
        map.put("loginPassword","123456");
        //容许谁访问
        map.put("allow","");
        //拒绝谁访问
        //map.put("deny","");
        bean.setInitParameters(map);
        return bean;
    }

    //配置一个监控的filter
    @Bean
    public FilterRegistrationBean filter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new WebStatFilter());
        Map<String, String> map = new HashMap<>();
        //排除监控哪些请求
        map.put("exclusions","/druid/*");
        bean.setInitParameters(map);
        //监控哪些请求
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;

    }


}
