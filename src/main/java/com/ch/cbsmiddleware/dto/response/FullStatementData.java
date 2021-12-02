package com.ch.cbsmiddleware.dto.response;

import lombok.*;

/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FullStatementData {
    private String miti;
    private String particulars;
    private String transactionType;
    private Double transactionAmount;
    private Double balance;
}
