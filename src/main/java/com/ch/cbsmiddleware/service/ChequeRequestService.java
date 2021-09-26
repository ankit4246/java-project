package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.request.ChequeRequest;
import com.ch.cbsmiddleware.dto.response.ChequeRequestResponse;

/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
public interface ChequeRequestService {
    ChequeRequestResponse getChequeRequest(ChequeRequest chequeRequest);
}
