package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.TransactionRequest;
import com.ch.cbsmiddleware.dto.response.HttpResponse;
import com.ch.cbsmiddleware.service.TransactionRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@RestController
@RequiredArgsConstructor
public class TransactionRequestController {

    private final TransactionRequestService transactionRequestService;

    @PostMapping("/transaction-request")
    public ResponseEntity<?> requestTransaction(@RequestBody TransactionRequest request){
        return ResponseEntity.ok(
                HttpResponse.getSuccessResponse("Transaction requested", transactionRequestService.requestTransaction(request))
        );
    }
}
