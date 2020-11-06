package com.zjrc.sm2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author xy
 * @version 1.0
 * @date 2020/10/5 13:59
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private ApiInfo createAI(){
        return new ApiInfoBuilder().title("SM2接口文档").
                contact(new Contact("zzrc","www.baidu.com","zzrc@163.com"))
                .version("1.0").description("这是一个SM2在线接口文档，可以直接查看接口的信息并且可以实现接口的测试")
                .build();
    }

    @Bean
    public Docket createD(){
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(createAI())
                .select().apis(RequestHandlerSelectors.basePackage("com.zjrc")).
                build();
    }
}
