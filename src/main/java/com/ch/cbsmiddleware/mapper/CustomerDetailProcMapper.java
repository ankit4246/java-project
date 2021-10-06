package com.ch.cbsmiddleware.mapper;

import com.ch.cbsmiddleware.dto.response.CustomerDetailByClientCodeResponse;
import com.ch.cbsmiddleware.dto.response.CustomerDetailByCustomerCodeResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 10/6/21
 */
@Mapper
public interface CustomerDetailProcMapper {
    List<CustomerDetailByClientCodeResponse> getCustomerDetailByClientCode(String cbsClientCode);
    CustomerDetailByCustomerCodeResponse getCustomerDetailByCustomerCode(String customerCode);
}
