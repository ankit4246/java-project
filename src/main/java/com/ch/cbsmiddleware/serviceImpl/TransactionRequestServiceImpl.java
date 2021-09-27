package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.request.TransactionRequest;
import com.ch.cbsmiddleware.models.TransactionDetail;
import com.ch.cbsmiddleware.models.TransactionStatus;
import com.ch.cbsmiddleware.repo.TransactionDetailRepo;
import com.ch.cbsmiddleware.service.TransactionRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Service
@RequiredArgsConstructor
public class TransactionRequestServiceImpl implements TransactionRequestService {

    private final TransactionDetailRepo transactionDetailRepo;

    @Override
    public String requestTransaction(TransactionRequest request) {

        //1. Log transaction as pending
        TransactionDetail persisted = transactionDetailRepo.save(TransactionDetail.buildFromRequest(request));

        //2. Call proc to get transaction id
        String transactionId = "12345";

        if (transactionId.isBlank()) {
            persisted.setTransactionStatus(TransactionStatus.FAILED);
            transactionDetailRepo.save(persisted);
            throw new RuntimeException();
        }

        //3. Set transactionId in transaction_detail table and mark as COMPLETED
        persisted.setTransactionId(transactionId);
        persisted.setTransactionStatus(TransactionStatus.COMPLETED);

        //4. Call proc to get voucher id
        String voucherNumber = "772BH";

        //5. Set voucherId in transaction_detail table
        persisted.setVoucherNumber(voucherNumber);
        transactionDetailRepo.save(persisted);

        return transactionId;
    }
}
