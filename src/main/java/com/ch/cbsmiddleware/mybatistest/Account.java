package com.ch.cbsmiddleware.mybatistest;

import lombok.*;

/**
 * @author bimal on 10/5/21
 * @project cbs-middleware
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Account {
    private int id;
    private String accountNumber;
}
