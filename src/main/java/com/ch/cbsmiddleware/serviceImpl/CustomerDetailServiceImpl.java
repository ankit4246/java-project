package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.config.MyBatisConfig;
import com.ch.cbsmiddleware.dto.request.CustomerDetailByClientCodeRequest;
import com.ch.cbsmiddleware.dto.request.CustomerDetailByCustomerCodeRequest;
import com.ch.cbsmiddleware.dto.response.BalanceEnquiryByCustomerCodeResponse;
import com.ch.cbsmiddleware.dto.response.CustomerDetailByClientCodeResponse;
import com.ch.cbsmiddleware.dto.response.CustomerDetailByCustomerCodeResponse;
import com.ch.cbsmiddleware.service.CustomerDetailService;
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
public class CustomerDetailServiceImpl implements CustomerDetailService {

    private final MyBatisConfig myBatisConfig;

    @Override
    public CustomerDetailByCustomerCodeResponse getCustomerDetailByCustomerCode(CustomerDetailByCustomerCodeRequest customerDetailByCustomerCodeRequest) {
        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(customerDetailByCustomerCodeRequest.getCbsClientCode());

        SqlSession session = factory.openSession();

        CustomerDetailByCustomerCodeResponse accounts = session.selectOne("getBalanceByCustomerCode", customerDetailByCustomerCodeRequest.getCustomerCode());

        session.close();

        return accounts;
    }

    @Override
    public List<CustomerDetailByClientCodeResponse> getCustomerDetailByClientCode(CustomerDetailByClientCodeRequest customerDetailByCientCodeRequest) {

        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(customerDetailByCientCodeRequest.getCbsClientCode());

        SqlSession session = factory.openSession();

        List<CustomerDetailByClientCodeResponse> accounts = session.selectList("getBalanceByCustomerCode", customerDetailByCientCodeRequest.getCbsClientCode());

        session.close();

        return accounts;
    }
}
