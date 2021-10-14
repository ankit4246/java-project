package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.config.MyBatisConfig;
import com.ch.cbsmiddleware.dto.request.ChequeRequest;
import com.ch.cbsmiddleware.dto.response.ChequeRequestResponse;
import com.ch.cbsmiddleware.service.ChequeRequestService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

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

    @Override
    public ChequeRequestResponse requestCheque(ChequeRequest chequeRequest) {

        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(chequeRequest.getCbsClientCode());

        SqlSession session = factory.openSession();

        Map<String, Object> params = new HashMap<>();
        params.put("cbsClientCode", chequeRequest.getCbsClientCode());
        params.put("accountNumber", chequeRequest.getAccountNumber());

        ChequeRequestResponse chequeRequestResponse = session.selectOne("requestCheque", params);

        session.close();
        return chequeRequestResponse;
     }
}
