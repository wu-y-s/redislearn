package com.wys.redislearn.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.google.common.base.Predicates.not;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.withMethodAnnotation;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(swaggerDemoApiInfo())
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.wys.redislearn.controller"))//要扫描的包
                //.apis(not(withMethodAnnotation(NotIncludeSwagger.class)))//自定义不生产文档
                // 设置范围：以/demo/开头的 url 才能被 swagger 生成接口文档
                // 如何希望全部扫描可以使用 paths(PathSelectors.any())
                .paths(allowPaths())
                .build();
    }

    private Predicate<String> allowPaths() {
        return or(regex("/test/.*"));
    }

    private ApiInfo swaggerDemoApiInfo() {
        return new ApiInfoBuilder()
                .contact(new Contact("百度", "www.baidu.com", "baidu@163.com"))
                // 标题
                .title("这是Swagger的标题")
                // 描述
                .description("这是Swagger的描述")
                // 版本
                .version("1.0.0")
                .build();
    }



}
