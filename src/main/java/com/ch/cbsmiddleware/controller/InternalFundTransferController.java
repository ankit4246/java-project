package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.InternalFundTransferRequest;
import com.ch.cbsmiddleware.dto.response.HttpResponse;
import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import com.ch.cbsmiddleware.service.InternalFundTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@RestController
@RequestMapping ("/internal-fund-transfer")
@RequiredArgsConstructor
public class InternalFundTransferController extends BaseController{

    private final InternalFundTransferService internalFundTransferService;

    @PostMapping
    public ResponseEntity<?> executeInternalFundTransfer(@Valid @RequestBody InternalFundTransferRequest request){
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("fund.transfer.success", internalFundTransferService.executeInternalFundTransfer(request))
        );
    }

}
