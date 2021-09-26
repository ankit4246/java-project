package com.ch.cbsmiddleware.dto.response;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
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
    private Integer availableBalance;
    @NotNull
    private Integer ledgerBalance;
    @NotNull
    private Integer interestRate;
    @NotNull
    private String accountStatus;
}
