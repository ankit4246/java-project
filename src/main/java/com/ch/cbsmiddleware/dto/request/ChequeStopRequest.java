package com.ch.cbsmiddleware.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChequeStopRequest {
    @NotBlank
    private String cbsClientCode;
    @NotBlank
    private String accountNumber;
    @NotBlank
    private String chequeNumber;
}
