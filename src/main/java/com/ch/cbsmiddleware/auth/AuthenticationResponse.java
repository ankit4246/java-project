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
@Builder
public class AuthenticationResponse {
    private String token;
    private String username;
}
