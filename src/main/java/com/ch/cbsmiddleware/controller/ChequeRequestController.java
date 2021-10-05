package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.ChequeRequest;
import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import com.ch.cbsmiddleware.service.ChequeRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
@RestController
@RequestMapping(value = "/cheque-request")
@RequiredArgsConstructor
public class ChequeRequestController extends BaseController {

    private final ChequeRequestService chequeRequestService;

    @GetMapping(value = "/")
    public ResponseEntity<?> getChequeRequest(@Valid @RequestBody ChequeRequest chequeRequest){
        chequeRequestService.getChequeRequest(chequeRequest);
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("retrieve.success","Cheque Request", chequeRequest)
        );
    }
}
