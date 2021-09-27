package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByAccountNumberRequest;
import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByCustomerCodeRequest;
import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import com.ch.cbsmiddleware.service.BalanceEnquiryService;
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
public class BalanceEnquiryController extends BaseController {

    private final BalanceEnquiryService balanceEnquiryService;

    public BalanceEnquiryController(ResponseGenerator responseGenerator, BalanceEnquiryService balanceEnquiryService) {
        super(responseGenerator);
        this.balanceEnquiryService = balanceEnquiryService;
    }

    @GetMapping(value = "/customer-code")
    public ResponseEntity<?> getBalanceByCustomerCode(@Valid @RequestBody BalanceEnquiryByCustomerCodeRequest balanceEnquiryByCustomerCodeRequest) {
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("balance-enquiry-customer-code.retrieve.success", balanceEnquiryService.getBalanceByCustomerCode(balanceEnquiryByCustomerCodeRequest))
        );
    }

    @GetMapping(value = "/account-number")
    public ResponseEntity<?> getBalanceByAccountNumber(@Valid @RequestBody BalanceEnquiryByAccountNumberRequest balanceEnquiryByAccountNumberRequest) {
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("balance-enquiry-account-number.retrieve.success", balanceEnquiryService.getBalanceByAccountNumber(balanceEnquiryByAccountNumberRequest))
        );
    }
}
