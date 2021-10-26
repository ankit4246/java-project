package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.VoucherRequest;
import com.ch.cbsmiddleware.dto.request.VoucherRequestOld;
import com.ch.cbsmiddleware.service.VoucherRequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "Voucher Request API")
public class VoucherRequestController extends BaseController{

    private final VoucherRequestService voucherRequestService;

    @ApiOperation(value = "Request for a Voucher number")
    @PostMapping("/request-voucher")
    public ResponseEntity<?> requestVoucher(@Valid @RequestBody VoucherRequest request){
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("voucher.request.success", voucherRequestService.requestVoucher(request))
        );
    }
}
