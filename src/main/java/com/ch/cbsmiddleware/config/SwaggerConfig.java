package com.ch.cbsmiddleware.config;

import com.ch.cbsmiddleware.dto.request.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.sql.Timestamp;

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
                .paths(PathSelectors.any())
                .build()
                .apiInfo(projectInfo())
                .ignoredParameterTypes(
                        //AccountListRequest.class,
                        /*BalanceEnquiryByAccountNumberRequest.class,
                        BalanceEnquiryByCustomerCodeRequest.class,
                        ChequeRequest.class,
                        ChequeStopRequest.class,
                        CustomerDetailByCustomerCodeRequest.class,
                        CustomerDetailByClientCodeRequest.class,
                        FullStatementRequest.class,
                        InternalFundTransferRequest.class,
                        MiniStatementRequest.class,
                        Timestamp.class,
                        TransactionRequest.class,
                        VoucherRequest.class*/
                );
    }

    private ApiInfo projectInfo(){
        return new ApiInfo(
                "CBS-middleware",
                "APIs for interacting with CBS",
                "1.0",
                "",
                "Code Himalaya",
                "Code Himalaya License",
                "https://codehimaya.com"
        );
    }
}
