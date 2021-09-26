package com.ch.cbsmiddleware.dto.response;

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
public class FullStatementResponse {
    @NotNull
    private String transactionDate;
    @NotNull
    private Number availableBalance;
    @NotNull
    private Number ledgerBalance;
    @NotNull
    private Number interestRate;
    @NotNull
    private String accountStatus;
}
