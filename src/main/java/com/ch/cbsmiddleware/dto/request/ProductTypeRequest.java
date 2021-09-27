package com.ch.cbsmiddleware.dto.request;

import lombok.*;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductTypeRequest {
    private String cbsClientCode;
}
