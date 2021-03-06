package com.ch.cbsmiddleware.dto.response;

import lombok.*;

/**
 * @author bimal on 9/27/21
 * @project cbs-middleware
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoucherData {
    private String voucherNumber;
    private long transactionId;
}
