package com.ch.cbsmiddleware.dto.request;

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
public class FullStatementRequest {
    @NotNull
    private String cbsClientCode;
    @NotNull
    private String accountNumber;
    @NotNull
    private Date fromDate;
    @NotNull
    private Date toDate;
    @NotNull
    private Number pageLimit;
    @NotNull
    private Number pageOffset;
}
