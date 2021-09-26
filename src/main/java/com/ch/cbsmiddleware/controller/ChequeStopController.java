package com.ch.cbsmiddleware.controller;

import com.ch.cbsmiddleware.dto.request.ChequeStopRequest;
import com.ch.cbsmiddleware.dto.response.HttpResponse;
import com.ch.cbsmiddleware.service.ChequeStopService;
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
public class ChequeStopController {

    private final ChequeStopService chequeStopService;

    @PostMapping("/stop-cheque")
    public ResponseEntity<?> stopCheque(@RequestBody ChequeStopRequest chequeStopRequest){
        chequeStopService.stopCheque(chequeStopRequest);
        return ResponseEntity.ok(
                HttpResponse.getSuccessResponse("Cheque Stopped", chequeStopRequest)
        );
    }

}
