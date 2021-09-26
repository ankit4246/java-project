package com.ch.cbsmiddleware.dto.response;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MiniStatementResponse {
    @NotNull
    private Date transactionDate;
    @NotNull
    private Number availableBalance;
    @NotNull
    private Number ledgerBalance;
    @NotNull
    private Number interestRate;
    @NotNull
    private String accountStatus;
}
