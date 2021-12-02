package com.ch.cbsmiddleware.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
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
    @NotBlank
    @NotNull
    private String cbsClientCode;
    @NotBlank
    @NotNull
    private String accountNumber;
    @NotNull
    private String fromDate;
    @NotNull
    private String toDate;
    @NotNull
    private String pageLimit;
    @NotNull
    private String pageOffset;
}
