package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.request.CustomerDetailByClientCodeRequest;
import com.ch.cbsmiddleware.dto.request.CustomerDetailByCustomerCodeRequest;
import com.ch.cbsmiddleware.dto.response.CustomerDetailByClientCodeResponse;
import com.ch.cbsmiddleware.dto.response.CustomerDetailByCustomerCodeResponse;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
public interface CustomerDetailService {
     List<CustomerDetailByClientCodeResponse> getCustomerDetailByClientCode(CustomerDetailByClientCodeRequest customerDetailByCientCodeRequest);

     CustomerDetailByCustomerCodeResponse getCustomerDetailByCustomerCode(CustomerDetailByCustomerCodeRequest customerDetailByCustomerCodeRequest);
}
