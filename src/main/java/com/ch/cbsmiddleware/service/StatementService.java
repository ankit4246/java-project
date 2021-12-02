package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.request.FullStatementRequest;
import com.ch.cbsmiddleware.dto.request.MiniStatementRequest;
import com.ch.cbsmiddleware.dto.response.StatementData;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
public interface StatementService {
    List<StatementData> getFullStatement(FullStatementRequest fullStatementRequest);

    List<StatementData> getMiniStatement(MiniStatementRequest miniStatementRequest);
}
