package com.ch.cbsmiddleware.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Project cbs-middleware
 * @Author mave on 10/8/21
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket projectAPIs() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ch.cbsmiddleware.controller"))
                //.paths(PathSelectors.ant("/*"))
                .build();
    }

    private ApiInfo projectInfo(){
        return new ApiInfo(
                "CBS-middleware API",
                "APIs for interacting with CBS",
                "1.0",
                "Undecided terms of use",
                "Code Himalaya",
                "Undecided License",
                "https://codehimaya.com"
        );
    }
}
