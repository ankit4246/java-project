package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.request.FullStatementRequest;
import com.ch.cbsmiddleware.dto.response.FullStatementResponse;
import com.ch.cbsmiddleware.service.FullStatementService;
import org.springframework.stereotype.Service;

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
                        "11/11/1111",
                        1111,
                        1111,
                        11,
                        "status111"
                ),
                new FullStatementResponse(
                        "22/22/2222",
                        2222,
                        2222,
                        22,
                        "status222"
                )
        );

        return fullStatementResponseList;
    }
}
