package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.request.CustomerDetailByClientCodeRequest;
import com.ch.cbsmiddleware.dto.request.CustomerDetailByCustomerCodeRequest;
import com.ch.cbsmiddleware.dto.response.CustomerData;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
public interface CustomerDetailService {
     List<CustomerData> getCustomerDetailByClientCode(CustomerDetailByClientCodeRequest customerDetailByCientCodeRequest);

     CustomerData getCustomerDetailByCustomerCode(CustomerDetailByCustomerCodeRequest customerDetailByCustomerCodeRequest);
}
