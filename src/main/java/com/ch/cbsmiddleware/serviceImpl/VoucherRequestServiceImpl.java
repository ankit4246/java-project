package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.request.VoucherRequest;
import com.ch.cbsmiddleware.dto.response.RequestVoucherData;
import com.ch.cbsmiddleware.models.Status;
import com.ch.cbsmiddleware.models.TransactionDetail;
import com.ch.cbsmiddleware.models.VoucherRequestLog;
import com.ch.cbsmiddleware.repo.TransactionDetailRepo;
import com.ch.cbsmiddleware.repo.VoucherRequestLogRepo;
import com.ch.cbsmiddleware.service.CsvFileWriter;
import com.ch.cbsmiddleware.service.VoucherRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Service
@RequiredArgsConstructor
public class VoucherRequestServiceImpl implements VoucherRequestService {

    private final TransactionDetailRepo transactionDetailRepo;
    private final VoucherRequestLogRepo voucherRequestLogRepo;
    private final CsvFileWriter csvFileWriter;

    @Override
    public RequestVoucherData requestVoucher(VoucherRequest request) {
        VoucherRequestLog voucherRequestLog = VoucherRequestLog.builder()
                .cbsClientCode(request.getCbsClientCode())
                .mobileNumber(request.getMobileNumber())
                .transactionId(request.getTransactionId())
                .transactionTimestamp(request.getTransactionTimestamp())
                .customerCommissionGL(request.getCustomerCommissionGL())
                .customerCommissionAmount(request.getCustomerCommissionAmount())
                .clientCommissionGL(request.getClientCommissionGL())
                .clientCommissionAmount(request.getClientCommissionAmount())
                .status(Status.PENDING)
                .build();

        Optional<TransactionDetail> optionalTransactionDetail =
                transactionDetailRepo.findByTransactionId(request.getTransactionId());


        if(optionalTransactionDetail.isEmpty()){
            voucherRequestLog.setStatus(Status.FAILED);
            throw new RuntimeException("transaction not found");
        }

        voucherRequestLog.setStatus(Status.COMPLETED);

        voucherRequestLogRepo.save(voucherRequestLog);

        csvFileWriter.writeVoucherRequest(voucherRequestLog);

        return RequestVoucherData.builder()
                .voucherNumber(optionalTransactionDetail.get().getVoucherNumber())
                .build();
    }
}
