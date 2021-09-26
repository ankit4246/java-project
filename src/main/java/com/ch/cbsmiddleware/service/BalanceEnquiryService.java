package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByAccountNumberRequest;
import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByCustomerCodeRequest;
import com.ch.cbsmiddleware.dto.response.AccountListResponse;
import com.ch.cbsmiddleware.dto.response.BalanceEnquiryByAccountNumberResponse;
import com.ch.cbsmiddleware.dto.response.BalanceEnquiryByCustomerCodeResponse;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
public interface BalanceEnquiryService {
    List<BalanceEnquiryByCustomerCodeResponse> getBalanceByCustomerCode(BalanceEnquiryByCustomerCodeRequest balanceEnquiryByCustomerCodeRequest);

    BalanceEnquiryByAccountNumberResponse getBalanceByAccountNumber(BalanceEnquiryByAccountNumberRequest balanceEnquiryByAccountNumberRequest);
}
