package com.zsw.netshop.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfig {

    @Bean
    public GroupedOpenApi adminApi() {              // 创建了一个api接口
        return GroupedOpenApi.builder()
                .group("admin-api")                 // 分组名称
                .pathsToMatch("/admin/**")          //接口请求路径
                .build();
    }

    /**
     * @description     自定义接口信息
     */
    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("云购商城API接口文档")
                        .version("1.0")
                        .description("云购商城API接口文档")
                        .contact(new Contact().name("zsw")));   //设定作者
    }
}
