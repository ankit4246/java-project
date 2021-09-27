package com.ch.cbsmiddleware.service;

import com.ch.cbsmiddleware.dto.request.MiniStatementRequest;
import com.ch.cbsmiddleware.dto.response.MiniStatementResponse;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
public interface MiniStatementService {
    List<MiniStatementResponse> getMiniStatement(MiniStatementRequest miniStatementRequest);
}
