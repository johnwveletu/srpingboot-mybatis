package com.example.srpingboot.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis配置类 使用配置类配置mybatis 另一种方法是使用配置文件的方式配置
 */
@Configuration
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer MyConfig(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                /*设置驼峰命名*/
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }

}
