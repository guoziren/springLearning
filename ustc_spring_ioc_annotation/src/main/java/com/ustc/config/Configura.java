package com.ustc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration  //配置类，里面@Bean用于方法 返回的对象放入spring容器
//<context:component-scan base-package="com.ustc"/>
@ComponentScan("com.ustc")  //从哪扫描注解创建bean
//context:property-placeholder location="classpath:jdbc.properties"/>
@PropertySource("classpath:jdbc.properties")   //读取配置文件
public class Configura {

    @Value("${driver}")
    private String driver;


    @Bean("dataSource") //Spring会将当前方法的返回值以指定名称存储到Spring容器中
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl("jdbc:mysql://localhost:3306/ustc");
        dataSource.setUsername("root");
        dataSource.setPassword("yyyyyyyy");
        return dataSource;
    }
}
