package com.ch.cbsmiddleware.dto.request;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
public class TransactionRequest {
    @NotBlank
    private String cbsClientCode;

    @NotBlank
    private String mobileNumber;

    @NotBlank
    private String accountNumber;

    @Min(value = 1)
    private int paymentAmount;

    private String paymentGL;

    @NotNull
    private Timestamp transactionTimestamp;

    private String customerCommissionGL;

    @Min(value = 0)
    private int customerCommissionAmount;

    private String gatewayCommissionGL;

    @Min(value = 0)
    private int gatewayCommissionAmount;

    private String clientCommissionGL;

    @Min(value = 0)
    private int clientCommissionAmount;

    @NotBlank
    private String beneficiaryNumber;

    @NotBlank
    private String remarks;

    @NotBlank
    private String serviceCode;

}
