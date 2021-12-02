package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.config.MyBatisConfig;
import com.ch.cbsmiddleware.dto.request.CustomerDetailByClientCodeRequest;
import com.ch.cbsmiddleware.dto.request.CustomerDetailByCustomerCodeRequest;
import com.ch.cbsmiddleware.dto.response.CustomerData;
import com.ch.cbsmiddleware.service.CustomerDetailService;
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
public class CustomerDetailServiceImpl implements CustomerDetailService {

    private final MyBatisConfig myBatisConfig;

    @Override
    public CustomerData getCustomerDetailByCustomerCode(CustomerDetailByCustomerCodeRequest customerDetailByCustomerCodeRequest) {
        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(customerDetailByCustomerCodeRequest.getCbsClientCode());

        SqlSession session = factory.openSession();

        CustomerData customerDetail = session.selectOne("getCustomerDetailByCustomerCode", customerDetailByCustomerCodeRequest.getCustomerCode());

        session.close();

        return customerDetail;
    }

    @Override
    public List<CustomerData> getCustomerDetailByClientCode(CustomerDetailByClientCodeRequest customerDetailByClientCodeRequest) {

        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(customerDetailByClientCodeRequest.getCbsClientCode());

        SqlSession session = factory.openSession();

        List<CustomerData> customerDetails = session.selectList("getCustomerDetailByClientCode", customerDetailByClientCodeRequest.getCbsClientCode());

        session.close();

        return customerDetails;
    }
}
