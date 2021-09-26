package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.AccountListRequest;
import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByAccountNumberRequest;
import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByCustomerCodeRequest;
import com.ch.cbsmiddleware.dto.response.AccountListResponse;
import com.ch.cbsmiddleware.dto.response.BalanceEnquiryByAccountNumberResponse;
import com.ch.cbsmiddleware.dto.response.BalanceEnquiryByCustomerCodeResponse;
import com.ch.cbsmiddleware.service.AccountListService;
import com.ch.cbsmiddleware.service.BalanceEnquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
@RestController
@RequestMapping(value = "/balance-enquiry")
@RequiredArgsConstructor
public class BalanceEnquiryController {

    private final BalanceEnquiryService balanceEnquiryService;

    @GetMapping(value = "/customer-code")
    public List<BalanceEnquiryByCustomerCodeResponse> getBalanceByCustomerCode(@RequestBody BalanceEnquiryByCustomerCodeRequest balanceEnquiryByCustomerCodeRequest){
        return balanceEnquiryService.getBalanceByCustomerCode(balanceEnquiryByCustomerCodeRequest);
    }

    @GetMapping(value = "/account-number")
    public BalanceEnquiryByAccountNumberResponse getBalanceByAccountNumber(@RequestBody BalanceEnquiryByAccountNumberRequest balanceEnquiryByAccountNumberRequest){
        return balanceEnquiryService.getBalanceByAccountNumber(balanceEnquiryByAccountNumberRequest);
    }
}
