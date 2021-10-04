package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.models.ChequeRequestLog;
import com.ch.cbsmiddleware.service.CsvFileWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

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
}
