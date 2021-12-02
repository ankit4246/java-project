package com.ch.cbsmiddleware.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class CustomerDetailByCustomerCodeRequest {
    @NotBlank
    @NotNull
    @JsonProperty(value = "client_code")
    private String cbsClientCode;
    @NotBlank
    @NotNull
    private String customerCode;
}
