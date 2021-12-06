package com.ch.cbsmiddleware.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;
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
public class InternalFundTransferRequest{
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp transactionTimestamp;
}
