package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.models.ChequeRequestLog;
import com.ch.cbsmiddleware.models.InternalFundTransfer;
import com.ch.cbsmiddleware.service.CsvFileWriter;
import org.springframework.stereotype.Service;

/**
 * @author bimal on 10/4/21
 * @project cbs-middleware
 */
@Service
public class CsvFileWriterImpl implements CsvFileWriter {
    @Override
    public void writeChequeRequest(ChequeRequestLog chequeRequestLog) {
        String csvPath = "src/main/resources/cheque_request.csv";

        String[] columnNames = new String[]{
                "id",
                "cbsClientCode",
                "accountNumber",
                "chequeNumber",
                "type",
                "timestamp",
                "status"
        };

        appendData(csvPath, columnNames, chequeRequestLog);

    }

    @Override
    public void writeInternalFundTransferDetail(InternalFundTransfer internalFundTransfer) {
        String cvsPath = "src/main/resources/ift.csv";

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
}
