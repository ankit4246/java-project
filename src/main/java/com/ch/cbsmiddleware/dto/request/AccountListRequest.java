package com.ch.cbsmiddleware.dto.request;

import lombok.*;

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
    @NotNull
    private String cbsClientCode;
    @NotNull
    private String customerCode;
}
