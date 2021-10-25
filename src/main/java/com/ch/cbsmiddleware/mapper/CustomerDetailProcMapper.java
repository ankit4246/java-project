package com.ch.cbsmiddleware.mapper;

import com.ch.cbsmiddleware.dto.response.CustomerDetailResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 10/6/21
 */
@Mapper
public interface CustomerDetailProcMapper {
    List<CustomerDetailResponse> getCustomerDetailByClientCode(String branchCode);
    CustomerDetailResponse getCustomerDetailByCustomerCode(String customerCode);
}
