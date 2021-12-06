package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.request.FullStatementRequest;
import com.ch.cbsmiddleware.dto.request.MiniStatementRequest;
import com.ch.cbsmiddleware.dto.response.statement.MiniStatementData;
import com.ch.cbsmiddleware.dto.response.statement.FullStatementData;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
public interface StatementService {
    List<FullStatementData> getFullStatement(FullStatementRequest fullStatementRequest);

    List<MiniStatementData> getMiniStatement(MiniStatementRequest miniStatementRequest);
}
