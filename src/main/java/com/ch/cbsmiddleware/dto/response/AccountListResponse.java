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
public class AccountListResponse {
    @NotNull
    private String accountNumber;
    @NotNull
    private String accountName;
    @NotNull
    private String currancyCode;
    @NotNull
    private String currancyName;
    @NotNull
    private String branchCode;
    @NotNull
    private String accountStatus;
    @NotNull
    private String accountType;
}
