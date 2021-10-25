package com.ch.cbsmiddleware.mapper;

import com.ch.cbsmiddleware.dto.response.MiniStatementResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 10/6/21
 */
@Mapper
public interface MiniStatementMapper {
    List<MiniStatementResponse> getMiniStatement(String accountNumber, String noOfTransactionCount);
}
