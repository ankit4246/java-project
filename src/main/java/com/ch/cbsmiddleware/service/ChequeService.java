package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.request.ChequeRequest;
import com.ch.cbsmiddleware.dto.request.ChequeStopRequest;
import com.ch.cbsmiddleware.dto.response.ChequeRequestResponse;

/**
 * @author bimal on 10/25/21
 * @project cbs-middleware
 */
public interface ChequeService {
    ChequeRequestResponse requestCheque(ChequeRequest chequeRequest);
    ChequeRequestResponse stopCheque(ChequeStopRequest request);

}
