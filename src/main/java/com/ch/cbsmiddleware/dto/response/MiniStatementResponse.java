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
public class MiniStatementResponse {
    @NotNull
    private Date transactionDate;
    @NotNull
    @NotNull
    private String particular;
    @NotNull
    @NotBlank
    private String transactionType;
    @NotNull
    private Integer transactionAmount;
    @NotNull
    private Integer balance;
}
