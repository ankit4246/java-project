package com.ch.cbsmiddleware.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BalanceEnquiryByAccountNumberRequest {
    @NotNull
    private String cbsClientCode;
    @NotNull
    private String accountNumber;
}
