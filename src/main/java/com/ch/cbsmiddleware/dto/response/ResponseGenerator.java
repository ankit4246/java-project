package com.ch.cbsmiddleware.dto.response;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Component
@RequiredArgsConstructor
public class ResponseGenerator {
    private final MessageSource messageSource;

    public HttpResponse getSuccessResponse(String messageCode, Object data) {
        return HttpResponse.builder()
                .statusCode(1)
                .statusText(messageSource.getMessage("status.success", null, Locale.ENGLISH))
                .message(messageSource.getMessage(messageCode, null, Locale.ENGLISH))
                .data(data)
                .build();
    }

    public HttpResponse getSuccessResponse(String messageCode, String param, Object data) {
        return HttpResponse.builder()
                .statusCode(1)
                .statusText(messageSource.getMessage("status.success", null, Locale.ENGLISH))
                .message(messageSource.getMessage(messageCode, new Object[]{param}, Locale.ENGLISH))
                .data(data)
                .build();
    }
}
