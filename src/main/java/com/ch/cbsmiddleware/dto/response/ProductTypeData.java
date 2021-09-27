package com.ch.cbsmiddleware.dto.response;

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
public class ProductTypeData {
    private String productTypeCode;
    private String productTypename;
}
