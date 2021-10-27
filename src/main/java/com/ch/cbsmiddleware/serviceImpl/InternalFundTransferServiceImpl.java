package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.config.MyBatisConfig;
import com.ch.cbsmiddleware.dto.request.InternalFundTransferRequest;
import com.ch.cbsmiddleware.dto.response.VoucherData;
import com.ch.cbsmiddleware.models.log.InternalFundTransferLog;
import com.ch.cbsmiddleware.constant.Status;
import com.ch.cbsmiddleware.repo.InternalFundTransferRepo;
import com.ch.cbsmiddleware.service.fileservice.CsvFileWriter;
import com.ch.cbsmiddleware.service.InternalFundTransferService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Service
@RequiredArgsConstructor
public class InternalFundTransferServiceImpl implements InternalFundTransferService {

    private final InternalFundTransferRepo internalFundTransferRepo;
    private final CsvFileWriter csvFileWriter;
    private final MyBatisConfig myBatisConfig;

    @Override
    public VoucherData executeInternalFundTransfer(InternalFundTransferRequest request) {

        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(request.getCbsClientCode());
        SqlSession session = factory.openSession();


        Map<String, Object> params = new HashMap<>();
        params.put("fromAccountNumber", request.getFromAccountNumber());
        params.put("toAccountNumber", request.getToAccountNumber());
        params.put("paymentAmount", request.getPaymentAmount());
        params.put("remarks", request.getRemarks());
        params.put("transactionTimestamp", request.getTransactionTimestamp());

        System.out.println(params);
        VoucherData voucherData = session.selectOne("executeInternalFundTransfer", params);
        //1. log this a pending
        InternalFundTransferLog persisted = internalFundTransferRepo.save(
                InternalFundTransferLog.buildFromRequest(request)
        );
        //2. call proc
        String voucherNumber = "12344";
//        String voucherNumber = voucherData.getVoucherNumber();
        System.out.println(voucherData);

        //3. if voucher is blank, mark as failed otherwise completed
        if (voucherNumber.isBlank()) {
            persisted.setStatus(Status.FAILED);
            internalFundTransferRepo.save(persisted);
            csvFileWriter.writeInternalFundTransferDetail(persisted);
            throw new RuntimeException(); //TODO: Make custom exception TransactionFailure
        }


        persisted
                .setStatus(Status.COMPLETED)
                .setVoucherNumber(voucherNumber);

        internalFundTransferRepo.save(persisted);

        csvFileWriter.writeInternalFundTransferDetail(persisted);

        session.close();

        return VoucherData.builder()
                .voucherNumber(voucherNumber)
                .build();
    }
}
