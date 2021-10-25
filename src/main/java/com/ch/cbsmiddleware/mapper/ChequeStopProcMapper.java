package com.ch.cbsmiddleware.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Project cbs-middleware
 * @Author mave on 10/6/21
 */
@Mapper
public interface ChequeStopProcMapper {
    void stopCheque(String accountNumber, String chequeNumber);
}
