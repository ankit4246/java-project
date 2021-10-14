package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.config.MyBatisConfig;
import com.ch.cbsmiddleware.dto.request.ChequeStopRequest;
import com.ch.cbsmiddleware.dto.response.ChequeRequestResponse;
import com.ch.cbsmiddleware.models.ChequeRequestLog;
import com.ch.cbsmiddleware.models.ChequeRequestType;
import com.ch.cbsmiddleware.models.Status;
import com.ch.cbsmiddleware.repo.ChequeRequestRepo;
import com.ch.cbsmiddleware.service.ChequeStopService;
import com.ch.cbsmiddleware.service.CsvFileWriter;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Service
@RequiredArgsConstructor
public class ChequeStopServiceImpl implements ChequeStopService {
    
    private final ChequeRequestRepo chequeRequestRepo;
    private final CsvFileWriter csvFileWriter;
    private final MyBatisConfig myBatisConfig;
    
    @Override
    public ChequeRequestResponse stopCheque(ChequeStopRequest request){
        ChequeRequestLog chequeRequestLog = ChequeRequestLog.builder()
                .cbsClientCode(request.getCbsClientCode())
                .accountNumber(request.getAccountNumber())
                .chequeNumber(request.getChequeNumber())
                .type(ChequeRequestType.STOP_CHEQUE_REQUEST)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .status(Status.PENDING)
                .build();

        //Call a proc and on the basis of response set status
        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(request.getCbsClientCode());

        SqlSession session = factory.openSession();
        Map<String, Object> params = new HashMap<>();
        params.put("accountNumber",request.getAccountNumber());
        params.put("chequeNumber", request.getChequeNumber());

        ChequeRequestResponse chequeRequestResponse = session.selectOne("stopCheque", params);

        chequeRequestLog.setStatus(Status.COMPLETED);

        session.close();

        return chequeRequestResponse;

        //chequeRequestRepo.save(chequeRequestLog);

        //Write to a csv file
//        csvFileWriter.writeChequeRequest(chequeRequestLog);

    }
}
