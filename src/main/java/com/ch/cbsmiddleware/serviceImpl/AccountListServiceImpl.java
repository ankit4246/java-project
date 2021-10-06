package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.config.MyBatisConfig;
import com.ch.cbsmiddleware.dto.request.AccountListRequest;
import com.ch.cbsmiddleware.dto.response.AccountListResponse;
import com.ch.cbsmiddleware.dto.response.CustomerDetailByClientCodeResponse;
import com.ch.cbsmiddleware.mybatistest.Account;
import com.ch.cbsmiddleware.service.AccountListService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
@Service
@RequiredArgsConstructor
public class AccountListServiceImpl implements AccountListService {
    private final MyBatisConfig myBatisConfig;

    @Override
    public List<AccountListResponse> getAccountListByCustomerCode(AccountListRequest accountListRequest) {

            SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(accountListRequest.getCbsClientCode());

            SqlSession session = factory.openSession();

            List<AccountListResponse> accounts = session.selectList("getAcountListByCustomerCode", accountListRequest.getCustomerCode());

            System.out.println(accounts);
            session.close();

            return accounts;

    }
}
