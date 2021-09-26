package com.ch.cbsmiddleware.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {
    private String cbsClientCode;
    private String mobileNumber;
    private String accountNumber;
    private int paymentAmount;
    private String paymentGL;
    private Timestamp transactionTimestamp;
    private String customerCommissionGL;
    private int customerCommissionAmount;
    private String gatewayCommissionGL;
    private int gatewayCommissionAmount;
    private String clientCommissionGL;
    private int clientCommissionAmount;
    private String beneficiaryNumber;
    private String remarks;
    private String serviceCode;

}
