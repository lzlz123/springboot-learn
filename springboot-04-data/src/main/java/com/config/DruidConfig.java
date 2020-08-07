package com.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDatasource() {
        return new DruidDataSource();
    }

    //后台监控功能
    @Bean
    public ServletRegistrationBean a() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        // 增加配置 密码
        HashMap<String, String> initparamers = new HashMap<>();
        initparamers.put("loginUsername", "123");//登入的 账号
        initparamers.put("loginPassword", "123");//登入的 密码

        //允许谁可以访问
        initparamers.put("allow", "");
        //禁止谁范围
        //        initparamers.put("lizhen","127.0.0.1")

        bean.setInitParameters(initparamers);//设置初始化操作
        return bean;

    }
}
