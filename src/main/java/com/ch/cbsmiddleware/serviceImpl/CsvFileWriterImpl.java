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
        String CSV_PATH = "src/main/resources/cheque_request.csv";
        File csvFile = new File(CSV_PATH);
        BufferedWriter writer;
        CSVPrinter csvPrinter;


        String[] columnNames = new String[]{
                "id",
                "cbsClientCode",
                "accountNumber",
                "chequeNumber",
                "type",
                "timestamp",
                "status"
        };

        try {
            if(!csvFile.exists()){
                writer = Files.newBufferedWriter(Paths.get(CSV_PATH));
                csvPrinter = new CSVPrinter(writer,
                        CSVFormat.DEFAULT.withHeader(columnNames));
            }else{
                writer = Files.newBufferedWriter(Paths.get(CSV_PATH),
                        StandardOpenOption.APPEND, StandardOpenOption.CREATE);
                csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
            }

            csvPrinter.printRecord(chequeRequestLog);

            writer.flush();
            writer.close();
            csvPrinter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
