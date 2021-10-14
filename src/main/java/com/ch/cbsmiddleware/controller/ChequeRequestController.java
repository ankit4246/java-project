package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.ChequeRequest;
import com.ch.cbsmiddleware.dto.response.ChequeRequestResponse;
import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import com.ch.cbsmiddleware.service.ChequeRequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "Cheque Request API")
public class ChequeRequestController extends BaseController {

    private final ChequeRequestService chequeRequestService;

    @ApiOperation(value = "Request Cheque book for an A/C number")
    @PostMapping(value = "/")
    public ChequeRequestResponse requestCheque(@Valid @RequestBody ChequeRequest chequeRequest){
       return chequeRequestService.requestCheque(chequeRequest);
    }
}
