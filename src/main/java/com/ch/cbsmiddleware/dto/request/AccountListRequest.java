package com.ch.cbsmiddleware.dto.request;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.Tag;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AccountListRequest {
    @NotBlank
    @NotNull
    @ApiModelProperty(name="CBS client code",required=true,value="Code assigned to client (Chimeki) to interact with CBS")
    private String cbsClientCode;
    @NotBlank
    @NotNull
    @ApiModelProperty(name="Customer code",required=true,value="Customer code of the A/C(s) holder")
    private String customerCode;
}
