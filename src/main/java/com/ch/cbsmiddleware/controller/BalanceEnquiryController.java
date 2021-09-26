package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByAccountNumberRequest;
import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByCustomerCodeRequest;
import com.ch.cbsmiddleware.dto.response.HttpResponse;
import com.ch.cbsmiddleware.service.BalanceEnquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
@RestController
@RequestMapping(value = "/balance-enquiry")
@RequiredArgsConstructor
public class BalanceEnquiryController {

    private final BalanceEnquiryService balanceEnquiryService;

    @GetMapping(value = "/customer-code")
    public ResponseEntity<?> getBalanceByCustomerCode(@RequestBody BalanceEnquiryByCustomerCodeRequest balanceEnquiryByCustomerCodeRequest) {
        return ResponseEntity.ok(
                HttpResponse.getSuccessResponse("Balance by Customer Code retrieved", balanceEnquiryService.getBalanceByCustomerCode(balanceEnquiryByCustomerCodeRequest))
        );
    }

    @GetMapping(value = "/account-number")
    public ResponseEntity<?> getBalanceByAccountNumber(@RequestBody BalanceEnquiryByAccountNumberRequest balanceEnquiryByAccountNumberRequest) {
        return ResponseEntity.ok(
                HttpResponse.getSuccessResponse("Balance by Account Number retrieved", balanceEnquiryService.getBalanceByAccountNumber(balanceEnquiryByAccountNumberRequest))
        );
    }
}
