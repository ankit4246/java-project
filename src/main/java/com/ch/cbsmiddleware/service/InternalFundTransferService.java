package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.request.InternalFundTransferRequest;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
public interface InternalFundTransferService {
    int executeInternalFundTransfer(InternalFundTransferRequest request);
}
