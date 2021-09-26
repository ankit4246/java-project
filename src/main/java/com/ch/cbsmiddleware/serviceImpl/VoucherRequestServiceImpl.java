package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.request.VoucherRequest;
import com.ch.cbsmiddleware.dto.response.RequestVoucherData;
import com.ch.cbsmiddleware.service.VoucherRequestService;
import org.springframework.stereotype.Service;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Service
public class VoucherRequestServiceImpl implements VoucherRequestService {

    @Override
    public RequestVoucherData requestVoucher(VoucherRequest request) {
        return RequestVoucherData.builder()
                .voucherNumber("728289").build();
    }
}
