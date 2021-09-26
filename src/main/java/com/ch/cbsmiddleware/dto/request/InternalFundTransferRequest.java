package com.ch.cbsmiddleware.dto.request;

import lombok.*;

import java.sql.Timestamp;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InternalFundTransferRequest {
    private String cbsClientCode;
    private String fromAccountNumber;
    private String toAccountNumber;
    private int paymentAmount;
    private String remarks;
    private Timestamp transactionTimestamp;
}
