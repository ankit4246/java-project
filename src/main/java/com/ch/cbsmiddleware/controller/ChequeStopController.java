package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.ChequeStopRequest;
import com.ch.cbsmiddleware.service.ChequeStopService;
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
public class ChequeStopController extends BaseController {

    private final ChequeStopService chequeStopService;

    @PostMapping("/stop-cheque")
    public ResponseEntity<?> stopCheque(@Valid @RequestBody ChequeStopRequest chequeStopRequest) {
        chequeStopService.stopCheque(chequeStopRequest);
        return ResponseEntity.ok(
                responseGenerator.getSuccessResponse("cheque.stop.success", chequeStopRequest)
        );

    }
}
