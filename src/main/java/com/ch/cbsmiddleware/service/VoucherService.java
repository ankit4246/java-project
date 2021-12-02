package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.request.VoucherRequest;
import com.ch.cbsmiddleware.dto.response.VoucherData;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */

public interface VoucherService {
    VoucherData requestVoucher(VoucherRequest request);

    String reverseVoucher(String cbsClientCode, String voucherNo);
}
