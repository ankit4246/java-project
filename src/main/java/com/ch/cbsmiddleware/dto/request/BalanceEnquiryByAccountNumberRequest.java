package com.ch.cbsmiddleware.dto.request;

import io.swagger.annotations.ApiModelProperty;
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
public class BalanceEnquiryByAccountNumberRequest {
    @NotBlank
    @NotNull
    @ApiModelProperty(name="CBS client code",required=true,value="Code assigned to client (Chimeki) to interact with CBS")
    private String cbsClientCode;
    @NotBlank
    @NotNull
    @ApiModelProperty(name="Account number",required=true,value="Account Number associated with a Customer")
    private String accountNumber;
}
