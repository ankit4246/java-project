package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.request.ChequeRequest;
import com.ch.cbsmiddleware.dto.response.ChequeRequestResponse;
import com.ch.cbsmiddleware.service.ChequeRequestService;
import org.springframework.stereotype.Service;

/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
@Service
public class ChequeRequestServiceImpl implements ChequeRequestService {
    @Override
    public ChequeRequestResponse getChequeRequest(ChequeRequest chequeRequest) {
        ChequeRequestResponse chequeRequestResponse = new ChequeRequestResponse(
                101,
                "status text 101",
                "response message 101"
        );
        return chequeRequestResponse;
    }
}
