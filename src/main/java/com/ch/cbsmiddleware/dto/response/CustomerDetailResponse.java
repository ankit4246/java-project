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
public class CustomerDetailResponse {
    @NotBlank
    @NotNull
    private String customerCode;
    @NotBlank
    @NotNull
    private String customerName;
    @NotBlank
    @NotNull
    private String address;
    @NotBlank
    @NotNull
    private String mobileNumber;
    @NotBlank
    @NotNull
    private String branchCode;
}
