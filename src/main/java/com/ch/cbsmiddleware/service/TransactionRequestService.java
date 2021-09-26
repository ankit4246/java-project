package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.request.TransactionRequest;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
public interface TransactionRequestService {
    String requestTransaction(TransactionRequest request);
}
