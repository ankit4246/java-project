
package com.ch.cbsmiddleware.serviceImpl.fileserviceimpl;

import com.ch.cbsmiddleware.constant.Fields;
import com.ch.cbsmiddleware.constant.LogTypes;
import com.ch.cbsmiddleware.models.log.ChequeRequestLog;
import com.ch.cbsmiddleware.models.log.InternalFundTransferLog;
import com.ch.cbsmiddleware.models.log.VoucherRequestLog;
import com.ch.cbsmiddleware.models.log.VoucherReversalLog;
import com.ch.cbsmiddleware.repo.LogMetaDataRepo;
import com.ch.cbsmiddleware.service.fileservice.CsvFileWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author bimal on 10/4/21
 * @project cbs-middleware
 */
@Service
@RequiredArgsConstructor
public class CsvFileWriterImpl implements CsvFileWriter {
    private final LogMetaDataRepo logMetaDataRepo;
    private final CsvFileNameGenerator csvFileNameGenerator;

    @Override
    public void writeChequeRequest(ChequeRequestLog chequeRequestLog) {
        String[] columnNames = new String[]{
                "id",
                "cbsClientCode",
                "accountNumber",
                "chequeNumber",
                "type",
                "timestamp",
                "status"
        };

        String csvPath = csvFileNameGenerator.generate(logMetaDataRepo, LogTypes.CHEQUE_REQUEST);
        appendData(csvPath, columnNames, chequeRequestLog);
    }

    @Override
    public void writeInternalFundTransferDetail(InternalFundTransferLog internalFundTransfer) {
        String cvsPath = csvFileNameGenerator.generate(logMetaDataRepo, LogTypes.INTERNAL_FUND_TRANSFER);

        String[] columnNames = new String[]{
                "cbsClientCode",
                "fromAccountNumber",
                "toAccountNumber",
                "paymentAmount",
                "remarks",
                "timestamp",
                "voucherNumber",
                "status"
        };

        appendData(cvsPath, columnNames, internalFundTransfer);
    }

    @Override
    public void writeVoucherRequest(VoucherRequestLog voucherRequest) {
        String cvsPath = csvFileNameGenerator.generate(logMetaDataRepo, LogTypes.VOUCHER_REQUEST);

        appendData(cvsPath, Fields.VOUCHER_REQUEST_LOG_FIELDS, voucherRequest);

    }

    @Override
    public void writeVoucherReversal(VoucherReversalLog voucherReversalLog) {
        String cvsPath = csvFileNameGenerator.generate(logMetaDataRepo, LogTypes.VOUCHER_REVERSAL);

        String[] columnNames = {
            "voucherNo",
            "status"
        };

        appendData(cvsPath, columnNames, voucherReversalLog);

    }
}
