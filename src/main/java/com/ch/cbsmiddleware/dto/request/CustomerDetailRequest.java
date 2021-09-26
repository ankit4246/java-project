package com.ch.cbsmiddleware.dto.request;

import lombok.*;
import org.jetbrains.annotations.NotNull;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDetailRequest {
    @NotNull
    private String cbsClientCode;
    private String branchCode;
}
