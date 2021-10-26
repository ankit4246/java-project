package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.request.VoucherRequest;
import com.ch.cbsmiddleware.dto.response.RequestVoucherData;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */

public interface VoucherService {
    RequestVoucherData requestVoucher(VoucherRequest request);

    String reverseVoucher(String cbsClientCode, String voucherNo);
}
