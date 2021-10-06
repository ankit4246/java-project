package com.ch.cbsmiddleware.dto.response;

import lombok.*;

import javax.validation.constraints.NotBlank;
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
    @NotBlank
    @NotNull
    private String accountNumber;
    @NotBlank
    @NotNull
    private String accountName;
    @NotBlank
    @NotNull
    private String currancyCode;
    @NotBlank
    @NotNull
    private String currancyName;
    @NotBlank
    @NotNull
    private String branchCode;
    @NotBlank
    @NotNull
    private String accountStatus;
    @NotBlank
    @NotNull
    private String accountType;
}
