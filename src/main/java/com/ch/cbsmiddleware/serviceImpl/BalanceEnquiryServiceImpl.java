package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.config.MyBatisConfig;
import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByAccountNumberRequest;
import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByCustomerCodeRequest;
import com.ch.cbsmiddleware.dto.response.BalanceData;
import com.ch.cbsmiddleware.service.BalanceEnquiryService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

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
    public List<BalanceData> getBalanceByCustomerCode(BalanceEnquiryByCustomerCodeRequest request) {

        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(request.getCbsClientCode());

        SqlSession session = factory.openSession();

        List<BalanceData> balances = session.selectList("getBalanceByCustomerCode", request.getCustomerCode());

        session.close();

        return balances;
    }

    @Override
    public BalanceData getBalanceByAccountNumber(BalanceEnquiryByAccountNumberRequest request) {

        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(request.getCbsClientCode());

        SqlSession session = factory.openSession();

        BalanceData balances = session.selectOne("getBalanceByAccNumber", request.getAccountNumber());

        session.close();

        return balances;
    }
}
