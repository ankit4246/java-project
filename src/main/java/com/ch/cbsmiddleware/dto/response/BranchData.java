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
public class BranchData {
    private String branchCode;
    private String branchName;
    private String branchType;
    private String branchContactNo;
    private String branchManagerName;
    private String branchManagerNumber;
    private String branchAddress;
    private String branchEmail;

}
