package com.ch.cbsmiddleware.dto.response;

import lombok.*;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDetailResponse {
    private String customerCode;
    private String customerName;
    private String address;
    private String mobileNumber;
    private String branchCode;
}
