package com.ch.cbsmiddleware.mapper;

import com.ch.cbsmiddleware.dto.response.ChequeRequestResponse;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Project cbs-middleware
 * @Author mave on 10/6/21
 */
@Mapper
public interface ChequeRequestProcMapper {
    void getChequeReq(String accNumber);
}
