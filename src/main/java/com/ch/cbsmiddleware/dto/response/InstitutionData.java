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
public class InstitutionData {
    private String cbsClientCode;
    private String name;
    private String contactNo;
    private String headOfficeManagerName;
    private String headOfficeManagerNumber;
    private String address;
    private String email;

}
