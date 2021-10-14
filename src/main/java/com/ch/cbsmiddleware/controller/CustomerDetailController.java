package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.CustomerDetailByClientCodeRequest;
import com.ch.cbsmiddleware.dto.request.CustomerDetailByCustomerCodeRequest;
import com.ch.cbsmiddleware.service.CustomerDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping(value = "/customer-detail")
@RequiredArgsConstructor
@Api(tags = "Customer Detail APIs")
public class CustomerDetailController extends BaseController {

    private final CustomerDetailService customerDetailService;

    @ApiOperation(value = "Lists Customer details on a specific Client")
    @GetMapping(value = "/client-code")
    public ResponseEntity<?> getCustomerDetailByClientCode(@Valid @RequestBody CustomerDetailByClientCodeRequest customerDetailRequest) {
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse(
                        "retrieve.success","Customer Detail",
                        customerDetailService.getCustomerDetailByClientCode(customerDetailRequest))
        );
    }

    @ApiOperation(value = "Get details of a specific Customer")
    @GetMapping(value = "/customer-code")
    public ResponseEntity<?> getCustomerDetailByCustomerCode(@Valid @RequestBody CustomerDetailByCustomerCodeRequest customerDetailByCustomerCodeRequest) {
         return ResponseEntity.ok(
                responseGenerator.getSuccessResponse(
                        "retrieve.success","Customer Detail",
                        customerDetailService.getCustomerDetailByCustomerCode(customerDetailByCustomerCodeRequest))
        );
    }

}
