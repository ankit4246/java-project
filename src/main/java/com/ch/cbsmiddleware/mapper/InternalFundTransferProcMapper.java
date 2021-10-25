package com.ch.cbsmiddleware.mapper;

import com.ch.cbsmiddleware.dto.response.VoucherData;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;

/**
 * @Project cbs-middleware
 * @Author mave on 10/6/21
 */
@Mapper
public interface InternalFundTransferProcMapper {
    VoucherData executeInternalFundTransfer(String fromAccountNumber,
                                            String toAccountNumber,
                                            int paymentAmount,
                                            String remarks,
                                            Timestamp transactionTimestamp);
}
