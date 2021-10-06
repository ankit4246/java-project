package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.config.MyBatisConfig;
import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByAccountNumberRequest;
import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByCustomerCodeRequest;
import com.ch.cbsmiddleware.dto.response.AccountListResponse;
import com.ch.cbsmiddleware.dto.response.BalanceEnquiryByAccountNumberResponse;
import com.ch.cbsmiddleware.dto.response.BalanceEnquiryByCustomerCodeResponse;
import com.ch.cbsmiddleware.dto.response.CustomerDetailByClientCodeResponse;
import com.ch.cbsmiddleware.service.BalanceEnquiryService;
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
public class BalanceEnquiryServiceImpl implements BalanceEnquiryService {

    private final MyBatisConfig myBatisConfig;
    @Override
    public List<BalanceEnquiryByCustomerCodeResponse> getBalanceByCustomerCode(BalanceEnquiryByCustomerCodeRequest balanceEnquiryByCustomerCodeRequest) {

        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(balanceEnquiryByCustomerCodeRequest.getCustomerCode());

        SqlSession session = factory.openSession();

        List<BalanceEnquiryByCustomerCodeResponse> accounts = session.selectList("getBalanceByCustomerCode", balanceEnquiryByCustomerCodeRequest.getCustomerCode());

        //System.out.println(accounts);
        session.close();

        return accounts;
    }

    @Override
    public BalanceEnquiryByAccountNumberResponse getBalanceByAccountNumber(BalanceEnquiryByAccountNumberRequest balanceEnquiryByAccountNumberRequest) {
        BalanceEnquiryByAccountNumberResponse balanceEnquiryByAccountNumberResponse = new BalanceEnquiryByAccountNumberResponse(
                "acntNo101",
                10000,
                1000,
                10,
                "status101"
        );

        return balanceEnquiryByAccountNumberResponse;
    }
}
