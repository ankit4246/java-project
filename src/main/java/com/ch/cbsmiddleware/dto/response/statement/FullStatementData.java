package com.ch.cbsmiddleware.dto.response.statement;

import lombok.*;

/**
 * @Project cbs-middleware
 * @Author mave on 12/6/21
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FullStatementData {
    private String miti;
    private String particulars;
    private Double transactionamount;
    private String transactiontype;
    private Double balance;
}
