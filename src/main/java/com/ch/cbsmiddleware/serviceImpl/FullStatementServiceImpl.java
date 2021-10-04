package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.request.FullStatementRequest;
import com.ch.cbsmiddleware.dto.response.FullStatementResponse;
import com.ch.cbsmiddleware.service.FullStatementService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
@Service
public class FullStatementServiceImpl implements FullStatementService {
    @Override
    public List<FullStatementResponse> getFullStatement(FullStatementRequest fullStatementRequest) {
        List<FullStatementResponse> fullStatementResponseList = List.of(
                new FullStatementResponse(
                        new Date(),
                        "particular101",
                        "t-Type101",
                        1000,
                        10000
                ),
                new FullStatementResponse(
                        new Date(),
                        "particular102",
                        "t-Type102",
                        2000,
                        20000
                )
        );

        return fullStatementResponseList;
    }
}
