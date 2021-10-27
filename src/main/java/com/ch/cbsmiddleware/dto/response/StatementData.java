package com.ch.cbsmiddleware.dto.response;

import lombok.*;

import java.math.BigDecimal;

/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StatementData {
    private String miti;
    private String description;
    private BigDecimal amount;
    private String type;
}
