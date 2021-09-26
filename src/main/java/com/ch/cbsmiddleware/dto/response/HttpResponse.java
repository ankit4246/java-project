package com.ch.cbsmiddleware.dto.response;

import lombok.*;
import org.springframework.http.HttpStatus;

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

    public static HttpResponse getSuccessResponse(String message, Object data){
        return HttpResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .statusText("SUCCESS")
                .message(message)
                .data(data)
                .build();
    }


}
