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

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@RestController
@RequestMapping ("/internal-fund-transfer")
public class InternalFundTransferController extends BaseController{

    private final InternalFundTransferService internalFundTransferService;

    public InternalFundTransferController(ResponseGenerator responseGenerator, InternalFundTransferService internalFundTransferService) {
        super(responseGenerator);
        this.internalFundTransferService = internalFundTransferService;
    }

    @PostMapping
    public ResponseEntity<?> executeInternalFundTransfer(@RequestBody InternalFundTransferRequest request){
        return ResponseEntity.ok(
                HttpResponse.getSuccessResponse("fund.transfer.success", internalFundTransferService.executeInternalFundTransfer(request))
        );
    }

}
