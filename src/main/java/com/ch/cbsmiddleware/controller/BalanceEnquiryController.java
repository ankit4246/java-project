package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByAccountNumberRequest;
import com.ch.cbsmiddleware.dto.request.BalanceEnquiryByCustomerCodeRequest;
import com.ch.cbsmiddleware.service.BalanceEnquiryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
@Api(tags = "Balance Enquiry APIs")
public class BalanceEnquiryController extends BaseController {

    private final BalanceEnquiryService balanceEnquiryService;

    @ApiOperation(value = "Lists remaining balance in all accounts associated with a particular Customer")
    @PostMapping(value = "/customer-code")
    public ResponseEntity<?> getBalanceByCustomerCode(@Valid @RequestBody BalanceEnquiryByCustomerCodeRequest balanceEnquiryByCustomerCodeRequest) {
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("retrieve.success", "Balance Enquiry", balanceEnquiryService.getBalanceByCustomerCode(balanceEnquiryByCustomerCodeRequest))
        );
    }

    @ApiOperation(value = "Get remaining balance in a particular A/C number")
    @PostMapping(value = "/account-number")
    public ResponseEntity<?> getBalanceByAccountNumber(@Valid @RequestBody BalanceEnquiryByAccountNumberRequest balanceEnquiryByAccountNumberRequest) {
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("retrieve.success", "Balance Enquiry", balanceEnquiryService.getBalanceByAccountNumber(balanceEnquiryByAccountNumberRequest))
        );
    }
}
