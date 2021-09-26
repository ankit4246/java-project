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
public class CustomerDetailByCustomerCodeResponse {
    @NotNull
    private String customerCode;
    @NotNull
    private String customerName;
    @NotNull
    private String address;
    @NotNull
    private String mobileNumber;
    @NotNull
    private String branchCode;
}
