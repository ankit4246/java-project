package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.request.FullStatementRequest;
import com.ch.cbsmiddleware.dto.response.FullStatementResponse;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
public interface FullStatementService {
    List<FullStatementResponse> getFullStatement(FullStatementRequest fullStatementRequest);
}
