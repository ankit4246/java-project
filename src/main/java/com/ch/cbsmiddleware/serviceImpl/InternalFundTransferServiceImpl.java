package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.request.InternalFundTransferRequest;
import com.ch.cbsmiddleware.service.InternalFundTransferService;
import org.springframework.stereotype.Service;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Service
public class InternalFundTransferServiceImpl implements InternalFundTransferService {

    @Override
    public int executeInternalFundTransfer(InternalFundTransferRequest request) {
        System.out.println(request);
        int voucherNo = 1;

        return voucherNo;
    }
}
