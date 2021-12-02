package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.VoucherRequest;
import com.ch.cbsmiddleware.service.VoucherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "Voucher Request API")
public class VoucherController extends BaseController{

    private final VoucherService voucherService;

    @ApiOperation(value = "Request for a Voucher number")
    @PostMapping("/request-voucher")
    public ResponseEntity<?> requestVoucher(@Valid @RequestBody VoucherRequest request){
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("voucher.request.success", voucherService.requestVoucher(request))
        );
    }

    @ApiOperation(value = "Reverse a Voucher")
    @GetMapping("/reverse-voucher")
    public ResponseEntity<?> reverseVoucher(@RequestParam("cbsClientCode")String cbsClientCode,
                                            @RequestParam("voucherNo") String voucherNo){
        return ResponseEntity.ok(
          responseGenerator.getSuccessResponse("voucher.reversal.success", voucherService.reverseVoucher(cbsClientCode, voucherNo))
        );
    }
}
