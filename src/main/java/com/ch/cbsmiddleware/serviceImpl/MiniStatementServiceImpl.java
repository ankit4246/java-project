package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.request.MiniStatementRequest;
import com.ch.cbsmiddleware.dto.response.MiniStatementResponse;
import com.ch.cbsmiddleware.service.MiniStatementService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
@Service
public class MiniStatementServiceImpl implements MiniStatementService {
    @Override
    public List<MiniStatementResponse> getMiniStatement(MiniStatementRequest miniStatementRequest) {
        List<MiniStatementResponse> miniStatementResponseList = List.of(
                new MiniStatementResponse(
                        new Date(),
                        "particular101",
                        "transactionType101",
                        1000,
                        10000
                ),
                new MiniStatementResponse(
                        new Date(),
                        "particular102",
                        "transactionType102",
                        2000,
                        20000
                )
        );
        return miniStatementResponseList;
    }
}
