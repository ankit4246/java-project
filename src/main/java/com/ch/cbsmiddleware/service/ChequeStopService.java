package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.request.ChequeStopRequest;

import java.io.IOException;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
public interface ChequeStopService {
    void stopCheque(ChequeStopRequest request);
}
