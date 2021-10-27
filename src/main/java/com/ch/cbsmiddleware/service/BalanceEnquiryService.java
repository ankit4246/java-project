package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByAccountNumberRequest;
import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByCustomerCodeRequest;
import com.ch.cbsmiddleware.dto.response.BalanceData;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
public interface BalanceEnquiryService {
    List<BalanceData> getBalanceByCustomerCode(BalanceEnquiryByCustomerCodeRequest balanceEnquiryByCustomerCodeRequest);

    BalanceData getBalanceByAccountNumber(BalanceEnquiryByAccountNumberRequest balanceEnquiryByAccountNumberRequest);
}
