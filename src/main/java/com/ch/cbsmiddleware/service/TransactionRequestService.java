package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.request.TransactionRequest;
import com.ch.cbsmiddleware.dto.response.TransactionData;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
public interface TransactionRequestService {
    TransactionData requestTransaction(TransactionRequest request);
}
