package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.request.VoucherRequest;
import com.ch.cbsmiddleware.dto.response.RequestVoucherData;
import com.ch.cbsmiddleware.models.TransactionDetail;
import com.ch.cbsmiddleware.repo.TransactionDetailRepo;
import com.ch.cbsmiddleware.service.VoucherRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Service
@RequiredArgsConstructor
public class VoucherRequestServiceImpl implements VoucherRequestService {

    private final TransactionDetailRepo transactionDetailRepo;

    @Override
    public RequestVoucherData requestVoucher(VoucherRequest request) {
        TransactionDetail transactionDetail = transactionDetailRepo.findByTransactionId(request.getTransactionId())
                .orElseThrow(RuntimeException::new);

        return RequestVoucherData.builder()
                .voucherNumber(transactionDetail.getVoucherNumber()).build();
    }
}
