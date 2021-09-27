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
@ToString
@Builder
public class HttpResponse {
    protected int statusCode;
    protected String statusText;
    protected String message;
    protected Object data;
}
