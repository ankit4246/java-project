package com.ch.cbsmiddleware.dto.response;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BalanceEnquiryByAccountNumberResponse {
    @NotBlank
    private String accountNumber;
    @NotNull
    private Integer availableBalance;
    @NotNull
    private Integer ledgerBalance;
    @NotNull
    private Integer interestRate;
    @NotBlank
    private String accountStatus;

}
