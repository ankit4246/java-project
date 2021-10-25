package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.config.MyBatisConfig;
import com.ch.cbsmiddleware.dto.request.ChequeRequest;
import com.ch.cbsmiddleware.dto.response.ChequeRequestResponse;
import com.ch.cbsmiddleware.models.ChequeRequestLog;
import com.ch.cbsmiddleware.models.ChequeRequestType;
import com.ch.cbsmiddleware.models.Status;
import com.ch.cbsmiddleware.repo.ChequeRequestRepo;
import com.ch.cbsmiddleware.service.ChequeRequestService;
import com.ch.cbsmiddleware.service.CsvFileWriter;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
@Service
@RequiredArgsConstructor
public class ChequeRequestServiceImpl implements ChequeRequestService {

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

        //Write to a csv file
        csvFileWriter.writeChequeRequest(chequeRequestLog);

        return chequeRequestResponse;
     }
}
