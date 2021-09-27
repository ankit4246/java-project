package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.request.InternalFundTransferRequest;
import com.ch.cbsmiddleware.dto.response.VoucherData;
import com.ch.cbsmiddleware.models.InternalFundTransfer;
import com.ch.cbsmiddleware.models.TransactionStatus;
import com.ch.cbsmiddleware.repo.InternalFundTransferRepo;
import com.ch.cbsmiddleware.service.InternalFundTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Service
@RequiredArgsConstructor
public class InternalFundTransferServiceImpl implements InternalFundTransferService {

    private final InternalFundTransferRepo internalFundTransferRepo;

    @Override
    public VoucherData executeInternalFundTransfer(InternalFundTransferRequest request) {
        //1. log this a pending
        InternalFundTransfer persisted = internalFundTransferRepo.save(
                InternalFundTransfer.buildFromRequest(request)
        );

        //2. call proc
        String voucherNumber = "82828ABS";

        //3. if voucher is blank, mark as failed otherwise completed
        if(voucherNumber.isBlank()){
            persisted.setTransactionStatus(TransactionStatus.FAILED);
            internalFundTransferRepo.save(persisted);
            throw new RuntimeException(); //TODO: Make custom exception TransactionFailure
        }

        persisted.setTransactionStatus(TransactionStatus.COMPLETED);
        internalFundTransferRepo.save(persisted);
        return VoucherData.builder()
                .voucherNumber(voucherNumber)
                .build();
    }
}
