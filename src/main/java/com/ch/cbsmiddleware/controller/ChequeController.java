package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.ChequeRequest;
import com.ch.cbsmiddleware.dto.request.ChequeStopRequest;
import com.ch.cbsmiddleware.dto.response.ChequeRequestResponse;
import com.ch.cbsmiddleware.service.ChequeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author bimal on 10/25/21
 * @project cbs-middleware
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "Cheque API")
public class ChequeController extends BaseController {

    private final ChequeService chequeService;

    @ApiOperation(value = "Request Cheque book for an A/C number")
    @PostMapping(value = "/cheque-request")
    public ChequeRequestResponse requestCheque(@Valid @RequestBody ChequeRequest chequeRequest){
        return chequeService.requestCheque(chequeRequest);
    }

    @ApiOperation(value = "Request to stop the payment on a Cheque related with an A/C number")
    @PostMapping("/stop-cheque")
    public ChequeRequestResponse stopCheque(@Valid @RequestBody ChequeStopRequest chequeStopRequest) {
        return chequeService.stopCheque(chequeStopRequest);
    }
}

