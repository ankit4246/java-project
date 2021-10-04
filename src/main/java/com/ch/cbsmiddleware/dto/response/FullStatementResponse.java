package com.ch.cbsmiddleware.dto.response;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Project cbs-middleware
 * @Author Om Narayan Singh on 9/26/21
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FullStatementResponse {
    @NotNull
    private Date transactionDate;
    @NotBlank
    @NotNull
    private String particular;
    @NotBlank
    @NotNull
    private String transactionType;
    @NotBlank
    @NotNull
    private Integer transactionAmount;
    @NotBlank
    @NotNull
    private Integer balance;
}
