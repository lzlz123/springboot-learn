package com.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 //开启swagger2
public class SwaggerConfig {

    //配置 swagger的实例
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .groupName("lizhen")
                //是否启动 swagger。 如果是false 则swagger不能在浏览器中访问
                //.enable(false)
                .select()
                //RequestHandlerSelectors配置 需要扫描接口的方式
                //basePackage==>指定需要扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.controller"))
                //path()  过滤什么路径
                //.paths(PathSelectors.any())
                .build();
    }

    //配置swaggerde  api-info
    private ApiInfo getApiInfo() {
        Contact lizhen = new Contact("lizhen", "", "");
        return new ApiInfo(
                "lizhen 的 日记",
                "swagger",
                "1.0",
                "urn:tos",
                lizhen,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0");
    }


}
