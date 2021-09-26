package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.request.FullStatementRequest;
import com.ch.cbsmiddleware.dto.response.FullStatementResponse;
import com.ch.cbsmiddleware.service.FullStatementService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
@Service
public class FullStatementServiceImpl implements FullStatementService {
    @Override
    public List<FullStatementResponse> getFullStatement(FullStatementRequest fullStatementRequest) {
        List<FullStatementResponse> fullStatementResponseList = List.of(
                new FullStatementResponse(
                        "10/10/1010",
                        1000,
                        1000,
                        10,
                        "status101"
                ),
                new FullStatementResponse(
                        "20/20/2020",
                        2000,
                        2000,
                        20,
                        "status202"
                )
        );

        return fullStatementResponseList;
    }
}
