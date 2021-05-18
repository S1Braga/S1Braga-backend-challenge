package com.train.supplytransport.supplytransportapplication.web.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class WebExceptionHandle extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

            final String errorMessage = ex.getParameterName() + " parameter is missing";

            return new ResponseEntity(WebExceptionResponse.builder()
                    .message("Request parameter is missing")
                    .realCause(errorMessage)
                    .statusCode(HttpStatus.BAD_REQUEST).build(),HttpStatus.BAD_REQUEST);

    }

}
