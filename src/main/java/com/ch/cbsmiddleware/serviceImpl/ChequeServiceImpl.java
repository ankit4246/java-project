package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.config.MyBatisConfig;
import com.ch.cbsmiddleware.dto.request.ChequeRequest;
import com.ch.cbsmiddleware.dto.request.ChequeStopRequest;
import com.ch.cbsmiddleware.dto.response.ChequeRequestResponse;
import com.ch.cbsmiddleware.models.log.ChequeRequestLog;
import com.ch.cbsmiddleware.constant.ChequeRequestType;
import com.ch.cbsmiddleware.constant.Status;
import com.ch.cbsmiddleware.repo.ChequeRequestRepo;
import com.ch.cbsmiddleware.service.ChequeService;
import com.ch.cbsmiddleware.service.fileservice.CsvFileWriter;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bimal on 10/25/21
 * @project cbs-middleware
 */
@Service
@RequiredArgsConstructor
public class ChequeServiceImpl implements ChequeService {

    private final MyBatisConfig myBatisConfig;
    private final ChequeRequestRepo chequeRequestRepo;
    private final CsvFileWriter csvFileWriter;

    @Override
    public ChequeRequestResponse requestCheque(ChequeRequest request) {
        ChequeRequestLog chequeRequestLog = ChequeRequestLog.builder()
                .cbsClientCode(request.getCbsClientCode())
                .accountNumber(request.getAccountNumber())
                .type(ChequeRequestType.NEW_CHEQUE_REQUEST)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .status(Status.PENDING)
                .build();

        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(request.getCbsClientCode());

        SqlSession session = factory.openSession();

        Map<String, Object> params = new HashMap<>();
        params.put("cbsClientCode", request.getCbsClientCode());
        params.put("accountNumber", request.getAccountNumber());

        ChequeRequestResponse chequeRequestResponse = session.selectOne("requestCheque", params);

        chequeRequestLog.setStatus(Status.COMPLETED);

        session.close();

        chequeRequestRepo.save(chequeRequestLog);

        csvFileWriter.writeChequeRequest(chequeRequestLog);

        return chequeRequestResponse;
    }

    @Override
    public ChequeRequestResponse stopCheque(ChequeStopRequest request) {
        ChequeRequestLog chequeRequestLog = ChequeRequestLog.builder()
                .cbsClientCode(request.getCbsClientCode())
                .accountNumber(request.getAccountNumber())
                .chequeNumber(request.getChequeNumber())
                .type(ChequeRequestType.STOP_CHEQUE_REQUEST)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .status(Status.PENDING)
                .build();

        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(request.getCbsClientCode());

        SqlSession session = factory.openSession();
        Map<String, Object> params = new HashMap<>();
        params.put("cbsClientCode", request.getCbsClientCode());
        params.put("accountNumber",request.getAccountNumber());
        params.put("chequeNumber", request.getChequeNumber());

        ChequeRequestResponse chequeRequestResponse = session.selectOne("stopCheque", params);

        chequeRequestLog.setStatus(Status.COMPLETED);

        session.close();

        chequeRequestRepo.save(chequeRequestLog);

        csvFileWriter.writeChequeRequest(chequeRequestLog);

        return chequeRequestResponse;
    }
}
