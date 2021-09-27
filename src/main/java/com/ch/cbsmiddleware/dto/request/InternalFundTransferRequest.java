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
public class InternalFundTransferRequest {
    @NotBlank
    private String cbsClientCode;
    @NotBlank
    private String fromAccountNumber;
    @NotBlank
    private String toAccountNumber;
    @Min(value = 1)
    private int paymentAmount;
    @NotBlank
    private String remarks;
    @NotNull
    private Timestamp transactionTimestamp;
}
