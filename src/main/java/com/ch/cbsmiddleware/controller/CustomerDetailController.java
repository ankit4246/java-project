package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.CustomerDetailByCientCodeRequest;
import com.ch.cbsmiddleware.dto.request.CustomerDetailByCustomerCodeRequest;
import com.ch.cbsmiddleware.dto.response.CustomerDetailByClientCodeResponse;
import com.ch.cbsmiddleware.dto.response.CustomerDetailByCustomerCodeResponse;
import com.ch.cbsmiddleware.service.CustomerDetailService;
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
@RequestMapping(value = "/customer-detail")
@RequiredArgsConstructor
public class CustomerDetailController {

    private final CustomerDetailService customerDetailService;

    @GetMapping(value = "/client-code")
    public List<CustomerDetailByClientCodeResponse> getCustomerDetailByClientCode(@RequestBody CustomerDetailByCientCodeRequest customerDetailRequest){
        return customerDetailService.getCustomerDetailByClientCode(customerDetailRequest);
    }

    @GetMapping(value = "/customer-code")
    public CustomerDetailByCustomerCodeResponse getCustomerDetailByCustomerCode(@RequestBody CustomerDetailByCustomerCodeRequest customerDetailByCustomerCodeRequest){
        return customerDetailService.getCustomerDetailByCustomerCode(customerDetailByCustomerCodeRequest);
    }

}
