package com.ch.cbsmiddleware.dto.response.statement;

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
public class MiniStatementData {
    private String miti;
    private String description;
    private Double amount;
    private String  type;
    private Double balance;
}
