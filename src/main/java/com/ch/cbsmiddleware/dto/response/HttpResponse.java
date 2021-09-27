package com.ch.cbsmiddleware.dto.response;

import lombok.*;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

import java.util.Locale;

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
