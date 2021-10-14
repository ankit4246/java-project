package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.ChequeStopRequest;
import com.ch.cbsmiddleware.dto.response.ChequeRequestResponse;
import com.ch.cbsmiddleware.service.ChequeStopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author bimal on 9/26/21
 * @Project cbs-middleware
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "Cheque stop API")
public class ChequeStopController extends BaseController {

    private final ChequeStopService chequeStopService;

    @ApiOperation(value = "Request to stop the payment on a Cheque related with an A/C number")
    @PostMapping("/stop-cheque")
    public ChequeRequestResponse stopCheque(@Valid @RequestBody ChequeStopRequest chequeStopRequest) {
        return chequeStopService.stopCheque(chequeStopRequest);
    }
}
