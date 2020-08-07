package com.lizhen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
@SpringBootApplication
    @SpringBootConfiguration ：springboot 的配置
        @Configuration : spring 的配置
            @component  这也是一个spring的组件


    @EnableAutoConfiguration  ：自动配置
        @AutoConfigurationPackage : 自动配置包
            @Import(AutoConfigurationPackages.Registrar.class)  ： 自动配置包注册
                  导入 和 注册 元数据
        @Import(AutoConfigurationImportSelector.class)  ： 导入选择
 */


//SpringBootApplication:标注这个类是 springboot 的应用
@SpringBootApplication
public class Springboot01HelloworldApplication {

    public static void main(String[] args) {
        //将 springboot 应用启动
        SpringApplication.run(Springboot01HelloworldApplication.class, args);
    }

}
