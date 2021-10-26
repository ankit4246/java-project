package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.config.MyBatisConfig;
import com.ch.cbsmiddleware.dto.request.FullStatementRequest;
import com.ch.cbsmiddleware.dto.request.MiniStatementRequest;
import com.ch.cbsmiddleware.dto.response.StatementData;
import com.ch.cbsmiddleware.service.StatementService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
@Service
@RequiredArgsConstructor
public class StatementServiceImpl implements StatementService {

    private final MyBatisConfig myBatisConfig;

    @Override
    public List<StatementData> getFullStatement(FullStatementRequest fullStatementRequest) {
        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(fullStatementRequest.getCbsClientCode());

        SqlSession session = factory.openSession();
        Map<String, Object> params = new HashMap<>();

        params.put("accountNumber", fullStatementRequest.getAccountNumber());
        params.put("fromDate", fullStatementRequest.getFromDate());
        params.put("toDate", fullStatementRequest.getToDate());
        params.put("pageLimit", fullStatementRequest.getPageLimit());
        params.put("pageOffset", fullStatementRequest.getPageOffset());

        List<StatementData> fullStatements = session.selectList("getFullStatement", params);

        session.close();

        return fullStatements;
    }


    @Override
    public List<StatementData> getMiniStatement(MiniStatementRequest miniStatementRequest) {
        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(miniStatementRequest.getCbsClientCode());

        SqlSession session = factory.openSession();
        Map<String, Object> params = new HashMap<>();
        params.put("accountNumber", miniStatementRequest.getAccountNumber());
        params.put("noOfTransactionCount", miniStatementRequest.getNoOfTransactionCount());

        List<StatementData> accounts = session.selectList("getMiniStatement", params);

        session.close();

        return accounts;
    }
}
