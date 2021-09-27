/*
package com.ch.cbsmiddleware.exception;

import com.ch.cbsmiddleware.dto.response.ResponseGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

*
 * @Project cbs-middleware
 * @Author mave on 9/27/21


@ControllerAdvice
@RequiredArgsConstructor
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    private final ResponseGenerator responseGenerator;

    @Override
    @ResponseBody
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        logger.info(ex.getClass().getName());
        //
        final List<String> errors = new ArrayList<String>();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            switch (error.getCode()) {
                case "NotNull":
                    errors.add(responseGenerator.getSuccessResponse("not-null.failure",));
                    break;
                case "NotBlank":
                    errors.add(responseGenerator.getSuccessResponse());
                    break;
                case "Pattern":
                    errors.add(responseGenerator.getSuccessResponse());
                    break;
                default:
                    errors.add(error.getField() + ": " + error.getDefaultMessage());
            }
        }
        for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        final ApiError apiError = new ApiError(ResponseStatus.FAILURE, httpStatus.value(), errors.get(0), errors);
        return handleExceptionInternal(ex, apiError, headers, httpStatus, request);
    }
}
*/
