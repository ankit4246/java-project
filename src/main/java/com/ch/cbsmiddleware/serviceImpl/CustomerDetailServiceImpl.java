package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.request.CustomerDetailByCientCodeRequest;
import com.ch.cbsmiddleware.dto.request.CustomerDetailByCustomerCodeRequest;
import com.ch.cbsmiddleware.dto.response.CustomerDetailByClientCodeResponse;
import com.ch.cbsmiddleware.dto.response.CustomerDetailByCustomerCodeResponse;
import com.ch.cbsmiddleware.service.CustomerDetailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
@Service
public class CustomerDetailServiceImpl implements CustomerDetailService {

    @Override
    public CustomerDetailByCustomerCodeResponse getCustomerDetailByCustomerCode(CustomerDetailByCustomerCodeRequest customerDetailByCustomerCodeRequest) {
        CustomerDetailByCustomerCodeResponse customerDetailByCustomerCodeResponse = new CustomerDetailByCustomerCodeResponse();
        customerDetailByCustomerCodeResponse.setCustomerCode("customerCode1");
        customerDetailByCustomerCodeResponse.setCustomerName("customerCode1");
        customerDetailByCustomerCodeResponse.setAddress("customerCode1");
        customerDetailByCustomerCodeResponse.setMobileNumber("customerCode1");
        customerDetailByCustomerCodeResponse.setBranchCode("customerCode1");

        return customerDetailByCustomerCodeResponse;
    }

    @Override
    public List<CustomerDetailByClientCodeResponse> getCustomerDetailByClientCode(CustomerDetailByCientCodeRequest customerDetailByCientCodeRequest) {
        List<CustomerDetailByClientCodeResponse> customerDetailList = new ArrayList<>();

        CustomerDetailByClientCodeResponse customerDetailByClientCodeResponse = new CustomerDetailByClientCodeResponse();
        customerDetailByClientCodeResponse.setCustomerCode("customerCode1");
        customerDetailByClientCodeResponse.setCustomerName("customerCode1");
        customerDetailByClientCodeResponse.setAddress("customerCode1");
        customerDetailByClientCodeResponse.setMobileNumber("customerCode1");
        customerDetailByClientCodeResponse.setBranchCode("customerCode1");

        CustomerDetailByClientCodeResponse customerDetailByClientCodeResponse1 = new CustomerDetailByClientCodeResponse();
        customerDetailByClientCodeResponse1.setCustomerCode("customerCode2");
        customerDetailByClientCodeResponse1.setCustomerName("customerCode2");
        customerDetailByClientCodeResponse1.setAddress("customerCode2");
        customerDetailByClientCodeResponse1.setMobileNumber("customerCode2");
        customerDetailByClientCodeResponse1.setBranchCode("customerCode2");

        customerDetailList.add(customerDetailByClientCodeResponse);
        customerDetailList.add(customerDetailByClientCodeResponse1);
          return customerDetailList;
    }
}
