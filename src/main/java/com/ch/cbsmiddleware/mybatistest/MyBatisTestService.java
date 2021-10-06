package com.ch.cbsmiddleware.mybatistest;

import com.ch.cbsmiddleware.config.MyBatisConfig;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bimal on 10/5/21
 * @project cbs-middleware
 */
@Service
@RequiredArgsConstructor
public class MyBatisTestService {

    private final MyBatisConfig myBatisConfig;

    public List<Account> getAccounts(String cbsClientCode) {

        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(cbsClientCode);

        SqlSession session = factory.openSession();

        List<Account> accounts = session.selectList("getAccounts");

        session.close();

        return accounts;
    }

    public List<Account> getAccountsXml(String cbsClientCode) {
        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(cbsClientCode);

        SqlSession session = factory.openSession();

        List<Account> accounts = session.selectList("getAccountsXml");

        session.close();

        return accounts;
    }
}
