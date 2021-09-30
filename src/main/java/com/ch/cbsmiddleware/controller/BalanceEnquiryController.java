package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByAccountNumberRequest;
import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByCustomerCodeRequest;
import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import com.ch.cbsmiddleware.service.BalanceEnquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
@RestController
@RequestMapping(value = "/balance-enquiry")
@RequiredArgsConstructor
public class BalanceEnquiryController extends BaseController {

    private final BalanceEnquiryService balanceEnquiryService;

    @GetMapping(value = "/customer-code")
    public ResponseEntity<?> getBalanceByCustomerCode(@Valid @RequestBody BalanceEnquiryByCustomerCodeRequest balanceEnquiryByCustomerCodeRequest) {
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("retrieve.success", "Balance Enquiry",balanceEnquiryService.getBalanceByCustomerCode(balanceEnquiryByCustomerCodeRequest))
        );
    }

    @GetMapping(value = "/account-number")
    public ResponseEntity<?> getBalanceByAccountNumber(@Valid @RequestBody BalanceEnquiryByAccountNumberRequest balanceEnquiryByAccountNumberRequest) {
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("retrieve.success","Balance Enquiry",balanceEnquiryService.getBalanceByAccountNumber(balanceEnquiryByAccountNumberRequest))
        );
    }
}
