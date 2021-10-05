package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.VoucherRequest;
import com.ch.cbsmiddleware.dto.response.HttpResponse;
import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import com.ch.cbsmiddleware.service.VoucherRequestService;
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
public class VoucherRequestController extends BaseController{

    private final VoucherRequestService voucherRequestService;

    @PostMapping("/request-voucher")
    public ResponseEntity<?> requestVoucher(@Valid @RequestBody VoucherRequest request){
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("voucher.request.success", voucherRequestService.requestVoucher(request))
        );
    }
}
