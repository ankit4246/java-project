package com.ch.cbsmiddleware.auth;

import lombok.*;

/**
 * @author bimal on 10/1/21
 * @project cbs-middleware
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthenticationRequest {
    private String email;
    private String password;

}
