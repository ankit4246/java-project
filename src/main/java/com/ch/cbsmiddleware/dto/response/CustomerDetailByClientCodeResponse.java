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
public class CustomerDetailByClientCodeResponse {
    @NotBlank
    private String customerCode;
    @NotBlank
    private String customerName;
    @NotBlank
    private String address;
    @NotBlank
    private String mobileNumber;
    @NotBlank
    private String branchCode;
}
