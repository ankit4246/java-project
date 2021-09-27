package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.TransactionRequest;
import com.ch.cbsmiddleware.dto.response.HttpResponse;
import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import com.ch.cbsmiddleware.service.TransactionRequestService;
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
public class TransactionRequestController extends BaseController{

    private final TransactionRequestService transactionRequestService;

    public TransactionRequestController(ResponseGenerator responseGenerator, TransactionRequestService transactionRequestService) {
        super(responseGenerator);
        this.transactionRequestService = transactionRequestService;
    }

    @PostMapping("/transaction-request")
    public ResponseEntity<?> requestTransaction(@Valid @RequestBody TransactionRequest request){
        System.out.println(request);
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("transaction.request.success", transactionRequestService.requestTransaction(request))
        );
    }
}
