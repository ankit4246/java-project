package com.ch.cbsmiddleware.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MiniStatementRequest {
    @NotBlank
    private String cbsClientCode;
    @NotBlank
    private String accountNumber;
    @NotBlank
    private String noOfTransactionCount;
}
