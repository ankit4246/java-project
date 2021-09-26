package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.ChequeRequest;
import com.ch.cbsmiddleware.dto.response.ChequeRequestResponse;
import com.ch.cbsmiddleware.service.ChequeRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
@RestController
@RequestMapping(value = "/cheque-request")
@RequiredArgsConstructor
public class ChequeRequestController {

    private final ChequeRequestService chequeRequestService;

    @GetMapping(value = "/")
    public ChequeRequestResponse getChequeRequest(@RequestBody ChequeRequest chequeRequest){
        return chequeRequestService.getChequeRequest(chequeRequest);
    }
}
