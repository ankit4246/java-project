package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.CustomerDetailByClientCodeRequest;
import com.ch.cbsmiddleware.dto.request.CustomerDetailByCustomerCodeRequest;
import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import com.ch.cbsmiddleware.service.CustomerDetailService;
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
@RequestMapping(value = "/customer-detail")
public class CustomerDetailController extends BaseController {

    private final CustomerDetailService customerDetailService;

    public CustomerDetailController(ResponseGenerator responseGenerator, CustomerDetailService customerDetailService) {
        super(responseGenerator);
        this.customerDetailService = customerDetailService;
    }

    @GetMapping(value = "/client-code")
    public ResponseEntity<?> getCustomerDetailByClientCode(@Valid @RequestBody CustomerDetailByClientCodeRequest customerDetailRequest) {
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse(
                        "retrieve.success","Customer Detail",
                        customerDetailService.getCustomerDetailByClientCode(customerDetailRequest))
        );
    }

    @GetMapping(value = "/customer-code")
    public ResponseEntity<?> getCustomerDetailByCustomerCode(@Valid @RequestBody CustomerDetailByCustomerCodeRequest customerDetailByCustomerCodeRequest) {
         return ResponseEntity.ok(
                responseGenerator.getSuccessResponse(
                        "retrieve.success","Customer Detail",
                        customerDetailService.getCustomerDetailByCustomerCode(customerDetailByCustomerCodeRequest))
        );
    }

}
