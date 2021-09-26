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
public class ChequeRequestResponse {
    @NotNull
    private Integer statusCode;
    @NotNull
    private String statusText;
    @NotNull
    private String message;
}
