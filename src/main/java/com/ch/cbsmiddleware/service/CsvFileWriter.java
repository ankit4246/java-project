package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.models.ChequeRequestLog;
import com.ch.cbsmiddleware.models.InternalFundTransfer;
import com.ch.cbsmiddleware.models.VoucherRequestLog;
import com.ch.cbsmiddleware.models.VoucherReversalLog;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author bimal on 10/4/21
 * @project cbs-middleware
 */
public interface CsvFileWriter {

    default void appendData(String csvPath, String[] columnNames, Object data) {
        File csvFile = new File(csvPath);

        BufferedWriter writer;
        CSVPrinter csvPrinter;
        try {
            if (!csvFile.exists()) {
                writer = Files.newBufferedWriter(Paths.get(csvPath));
                csvPrinter = new CSVPrinter(writer,
                        CSVFormat.DEFAULT.withHeader(columnNames));
            } else {
                writer = Files.newBufferedWriter(Paths.get(csvPath),
                        StandardOpenOption.APPEND, StandardOpenOption.CREATE);
                csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
            }
            csvPrinter.printRecord(data);

            writer.flush();
            writer.close();
            csvPrinter.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    void writeChequeRequest(ChequeRequestLog chequeRequestLog);
    void writeInternalFundTransferDetail(InternalFundTransfer internalFundTransfer);
    void writeVoucherRequest(VoucherRequestLog voucherRequestLog);
    void writeVoucherReversal(VoucherReversalLog voucherReversalLog);

}
