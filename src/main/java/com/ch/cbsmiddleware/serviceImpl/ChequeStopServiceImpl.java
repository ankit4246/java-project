package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.request.ChequeStopRequest;
import com.ch.cbsmiddleware.models.ChequeRequestLog;
import com.ch.cbsmiddleware.models.ChequeRequestType;
import com.ch.cbsmiddleware.models.Status;
import com.ch.cbsmiddleware.repo.ChequeRequestRepo;
import com.ch.cbsmiddleware.service.ChequeStopService;
import com.ch.cbsmiddleware.service.CsvFileWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Service
@RequiredArgsConstructor
public class ChequeStopServiceImpl implements ChequeStopService {
    
    private final ChequeRequestRepo chequeRequestRepo;
    private final CsvFileWriter csvFileWriter;
    
    @Override
    public void stopCheque(ChequeStopRequest request){
        ChequeRequestLog chequeRequestLog = ChequeRequestLog.builder()
                .cbsClientCode(request.getCbsClientCode())
                .accountNumber(request.getAccountNumber())
                .chequeNumber(request.getChequeNumber())
                .type(ChequeRequestType.STOP_CHEQUE_REQUEST)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .status(Status.PENDING)
                .build();

        //Call a proc and on the basis of response set status

        chequeRequestLog.setStatus(Status.COMPLETED);

        chequeRequestRepo.save(chequeRequestLog);

        //Write to a csv file
        csvFileWriter.writeChequeRequest(chequeRequestLog);

    }
}
