package com.ch.cbsmiddleware;

import com.ch.cbsmiddleware.models.CbsDbConnectionDetail;
import com.ch.cbsmiddleware.repo.CbsDbConnectionDetailRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@RequiredArgsConstructor
public class CbsMiddlewareApplication implements CommandLineRunner {

	private final CbsDbConnectionDetailRepo cbsDbConnectionDetailRepo;

	public static void main(String[] args) {
		SpringApplication.run(CbsMiddlewareApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
				/*String host = "202.51.1.183";
				String port = "1433";
				String userName = "sa";
				String dbName = "Subharabhma_Demo";
				String dbPassword = "lunev@#6520$sil@v#rl";
				String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				String dbUrl = "jdbc:sqlserver://"+host+":"+port+";databaseName="+dbName;
        CbsDbConnectionDetail connectionDetail =
                CbsDbConnectionDetail.builder()
                        .cbsClientCode("1")
                        .dbUserName(userName)
                        .dbPassword(dbPassword)
                        .dbDriver(dbDriver)
                        .dbUrl(dbUrl)
                        .dbName(dbName)
                        .build();

        cbsDbConnectionDetailRepo.save(connectionDetail);*/

	}
}
