package com.ch.cbsmiddleware.mapper;

import com.ch.cbsmiddleware.dto.response.BalanceEnquiryByAccountNumberResponse;
import com.ch.cbsmiddleware.dto.response.BalanceEnquiryByCustomerCodeResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 10/6/21
 */
@Mapper
public interface BalanceEnquiryProcMapper {
    List<BalanceEnquiryByCustomerCodeResponse> getBalanceByCustomerCode(String customerCode);
    BalanceEnquiryByAccountNumberResponse getBalanceByAccountNumber(String accountNumber);
}
