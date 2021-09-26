package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByAccountNumberRequest;
import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByCustomerCodeRequest;
import com.ch.cbsmiddleware.dto.response.AccountListResponse;
import com.ch.cbsmiddleware.dto.response.BalanceEnquiryByAccountNumberResponse;
import com.ch.cbsmiddleware.dto.response.BalanceEnquiryByCustomerCodeResponse;
import com.ch.cbsmiddleware.dto.response.CustomerDetailByClientCodeResponse;
import com.ch.cbsmiddleware.service.BalanceEnquiryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
@Service
public class BalanceEnquiryServiceImpl implements BalanceEnquiryService {
    @Override
    public List<BalanceEnquiryByCustomerCodeResponse> getBalanceByCustomerCode(BalanceEnquiryByCustomerCodeRequest balanceEnquiryByCustomerCodeRequest) {
        List<BalanceEnquiryByCustomerCodeResponse> balanceEnquiryByCustomerCodeResponseList = List.of(
                new BalanceEnquiryByCustomerCodeResponse(
                        "accNo101",
                        1000,
                        1000,
                        1000,
                        "accStts101"),
                new BalanceEnquiryByCustomerCodeResponse(
                        "accNo101",
                        1000,
                        1000,
                        1000,
                        "accStts101")
        );

        return balanceEnquiryByCustomerCodeResponseList;
    }

    @Override
    public BalanceEnquiryByAccountNumberResponse getBalanceByAccountNumber(BalanceEnquiryByAccountNumberRequest balanceEnquiryByAccountNumberRequest) {
        BalanceEnquiryByAccountNumberResponse balanceEnquiryByAccountNumberResponse = new BalanceEnquiryByAccountNumberResponse();
        balanceEnquiryByAccountNumberResponse.setAccountNumber("accNum101");
        balanceEnquiryByAccountNumberResponse.setAvailableBalance(10000);
        balanceEnquiryByAccountNumberResponse.setLedgerBalance(10000);
        balanceEnquiryByAccountNumberResponse .setInterestRate(2);
        balanceEnquiryByAccountNumberResponse.setAccountStatus("sttus101");

        return balanceEnquiryByAccountNumberResponse;
    }
}
