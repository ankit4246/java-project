package com.ch.cbsmiddleware.dto.response;

import lombok.*;

import javax.validation.constraints.NotBlank;

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
    private String accountNumber;
    @NotBlank
    private String accountName;
    @NotBlank
    private String currancyCode;
    @NotBlank
    private String currancyName;
    @NotBlank
    private String branchCode;
    @NotBlank
    private String accountStatus;
    @NotBlank
    private String accountType;
}
