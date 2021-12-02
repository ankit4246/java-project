package com.ch.cbsmiddleware.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
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
public class VoucherRequest {
    @NotBlank
    private String cbsClientCode;

    @NotBlank
    private String mobileNumber;

    @NotBlank
    private String accountNumber;

    private BigDecimal paymentAmount;

    @NotNull
    private Timestamp transactionTimestamp;

    private BigDecimal customerCommissionAmount;

    private BigDecimal clientCommissionAmount;

    @NotBlank
    private String beneficiaryNumber;

    @NotBlank
    private String remarks;

    private String service;

    private int serviceCode;

    private String serviceType;

    private String bankName;

}
