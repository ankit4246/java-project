package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.ChequeRequest;
import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import com.ch.cbsmiddleware.service.ChequeRequestService;
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
@RequestMapping(value = "/cheque-request")
public class ChequeRequestController extends BaseController {

    private final ChequeRequestService chequeRequestService;

    public ChequeRequestController(ResponseGenerator responseGenerator, ChequeRequestService chequeRequestService) {
        super(responseGenerator);
        this.chequeRequestService = chequeRequestService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> getChequeRequest(@Valid @RequestBody ChequeRequest chequeRequest){
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("retrieve.success","Cheque Request", chequeRequestService.getChequeRequest(chequeRequest))
        );
    }
}
