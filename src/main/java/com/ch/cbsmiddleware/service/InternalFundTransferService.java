package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.request.InternalFundTransferRequest;
import com.ch.cbsmiddleware.dto.response.VoucherData;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
public interface InternalFundTransferService {
    VoucherData executeInternalFundTransfer(InternalFundTransferRequest request);
}
