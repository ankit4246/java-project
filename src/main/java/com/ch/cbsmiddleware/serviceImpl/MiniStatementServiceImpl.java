package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.config.MyBatisConfig;
import com.ch.cbsmiddleware.dto.request.MiniStatementRequest;
import com.ch.cbsmiddleware.dto.response.MiniStatementResponse;
import com.ch.cbsmiddleware.service.MiniStatementService;
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
public class MiniStatementServiceImpl implements MiniStatementService {

    private final MyBatisConfig myBatisConfig;

    @Override
    public List<MiniStatementResponse> getMiniStatement(MiniStatementRequest miniStatementRequest) {
        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(miniStatementRequest.getCbsClientCode());

        SqlSession session = factory.openSession();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("accountNumber", miniStatementRequest.getAccountNumber());
        params.put("noOfTransactionCount", miniStatementRequest.getNoOfTransactionCount());

        List<MiniStatementResponse> accounts = session.selectList("getMiniStatement", params);

        session.close();

        return accounts;
    }
}
