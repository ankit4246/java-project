package com.ch.cbsmiddleware.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChequeStopRequest {
    private String cbsClientCode;
    private String accountNumber;
    private String chequeNumber;
}
