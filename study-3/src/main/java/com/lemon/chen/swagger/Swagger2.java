package com.lemon.chen.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by chenhualong on 2016/11/13.
 *
 * 本来主要是设置Swagger2的相关信息， 拷贝就好
 *
 *
 * http://localhost:8089/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class Swagger2 {


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lemon.chen"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("使用Spring Boot中使用Swagger2构建RESTful API")
                .description("重庆猪八戒网络有限公司——移动技术陈华龙")
                .termsOfServiceUrl("http://www.zbj.com/")
                .contact("陈华龙")
                .version("1.0")
                .build();
    }
}
