package com.ch.cbsmiddleware.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class VoucherRequest {
    @NotBlank
    private String cbsClientCode;

    @NotBlank
    private String mobileNumber;

    @NotBlank
    private String transactionId;

    @NotNull
    private Timestamp transactionTimestamp;
}
