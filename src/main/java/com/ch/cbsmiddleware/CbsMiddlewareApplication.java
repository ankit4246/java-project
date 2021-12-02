package com.ch.cbsmiddleware;

import com.ch.cbsmiddleware.auth.Admin;
import com.ch.cbsmiddleware.auth.AdminRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@RequiredArgsConstructor
public class CbsMiddlewareApplication implements CommandLineRunner {


	private final AdminRepo adminRepo;

	public static void main(String[] args) {
		SpringApplication.run(CbsMiddlewareApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		adminRepo.save(Admin.builder()
//				.email("abc@gmail.com")
//				.password("123")
//				.build());
	}
}
