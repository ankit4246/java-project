package com.ch.cbsmiddleware.config;

import com.ch.cbsmiddleware.models.CbsDbConnectionDetail;
import com.ch.cbsmiddleware.repo.CbsDbConnectionDetailRepo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author bimal on 10/5/21
 * @project cbs-middleware
 */
@Component
@RequiredArgsConstructor
public class MyBatisConfig {

    private final Map<String, SqlSessionFactory> sqlSessionFactoryMap = new HashMap<>();
    private final CbsDbConnectionDetailRepo cbsDbConnectionDetailRepo;

    public SqlSessionFactory getSqlSessionFactory(String cbsClientCode) {

        if (sqlSessionFactoryMap.containsKey(cbsClientCode)) {
            return sqlSessionFactoryMap.get(cbsClientCode);
        }
        CbsDbConnectionDetail connectionDetail = cbsDbConnectionDetailRepo
                .findByCbsClientCode(cbsClientCode)
                .orElseThrow(RuntimeException::new);

        SqlSessionFactory factory = null;

        try {
            Reader reader = Resources.getResourceAsReader("mybatis_config.xml");

            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

            Properties properties = new Properties();
            properties.put("driver", connectionDetail.getDbDriver());
            properties.put("url", connectionDetail.getDbUrl());
            properties.put("username", connectionDetail.getDbUserName());
            properties.put("password", connectionDetail.getDbPassword());

            factory = builder.build(reader, properties);

            sqlSessionFactoryMap.put(cbsClientCode, factory);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return factory;
    }

}
