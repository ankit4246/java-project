package com.ch.cbsmiddleware;

import com.ch.cbsmiddleware.models.CbsDbConnectionDetail;
import com.ch.cbsmiddleware.repo.CbsDbConnectionDetailRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class CbsMiddlewareApplication implements CommandLineRunner {

	private final CbsDbConnectionDetailRepo cbsDbConnectionDetailRepo;

	public static void main(String[] args) {
		SpringApplication.run(CbsMiddlewareApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		        String dbUrl = "jdbc:postgresql://localhost:5432/";
//        CbsDbConnectionDetail connectionDetail =
//                CbsDbConnectionDetail.builder()
//                        .cbsClientCode("1")
//                        .dbUserName("postgres")
//                        .dbPassword("postgres")
//                        .dbDriver("org.postgresql.Driver")
//                        .dbUrl(dbUrl+"client1")
//                        .dbName("client1")
//                        .build();
//
//        CbsDbConnectionDetail connectionDetail2 =
//                CbsDbConnectionDetail.builder()
//                        .cbsClientCode("2")
//                        .dbUserName("postgres")
//                        .dbPassword("postgres")
//                        .dbDriver("org.postgresql.Driver")
//                        .dbUrl(dbUrl+"client2")
//                        .dbName("client2")
//                        .build();
//
//
//        cbsDbConnectionDetailRepo.save(connectionDetail);
//        cbsDbConnectionDetailRepo.save(connectionDetail2);

	}
}
