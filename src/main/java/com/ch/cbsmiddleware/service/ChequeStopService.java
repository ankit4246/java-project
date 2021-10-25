package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.request.ChequeStopRequest;
import com.ch.cbsmiddleware.dto.response.ChequeRequestResponse;

import java.io.IOException;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
public interface ChequeStopService {
    ChequeRequestResponse stopCheque(ChequeStopRequest request);
}
