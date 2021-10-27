package com.ch.cbsmiddleware;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@RequiredArgsConstructor
public class CbsMiddlewareApplication {


	public static void main(String[] args) {
		SpringApplication.run(CbsMiddlewareApplication.class, args);
	}

}
