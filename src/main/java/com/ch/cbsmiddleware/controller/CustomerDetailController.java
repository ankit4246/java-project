package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.CustomerDetailByCientCodeRequest;
import com.ch.cbsmiddleware.dto.request.CustomerDetailByCustomerCodeRequest;
import com.ch.cbsmiddleware.dto.response.HttpResponse;
import com.ch.cbsmiddleware.service.CustomerDetailService;
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
@RequestMapping(value = "/customer-detail")
@RequiredArgsConstructor
public class CustomerDetailController {

    private final CustomerDetailService customerDetailService;

    @GetMapping(value = "/client-code")
    public ResponseEntity<?> getCustomerDetailByClientCode(@RequestBody CustomerDetailByCientCodeRequest customerDetailRequest) {
        return ResponseEntity.ok(
                HttpResponse.getSuccessResponse("Customer detail by Client Code retrieved", customerDetailService.getCustomerDetailByClientCode(customerDetailRequest))
        );
    }

    @GetMapping(value = "/customer-code")
    public ResponseEntity<?> getCustomerDetailByCustomerCode(@RequestBody CustomerDetailByCustomerCodeRequest customerDetailByCustomerCodeRequest) {
        return ResponseEntity.ok(
                HttpResponse.getSuccessResponse("Customer detail by Customer Code retrieved", customerDetailService.getCustomerDetailByCustomerCode(customerDetailByCustomerCodeRequest))
        );
    }

}
