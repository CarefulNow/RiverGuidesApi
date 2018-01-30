package com.bazinga.riverguides.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by CarefulNow on 7/6/17.
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableSwagger2
public class Application {
    public static void main(String[] argc) {
        SpringApplication.run(Application.class, argc);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bazinga.riverguides.api.controllers"))
                .paths(PathSelectors.any())
                .build();
    }
}
