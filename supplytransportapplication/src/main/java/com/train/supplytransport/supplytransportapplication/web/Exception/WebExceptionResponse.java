package com.train.supplytransport.supplytransportapplication.web.Exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Builder
public class WebExceptionResponse {

    private final String path;
    private final HttpStatus statusCode;
    private final String message;
    private final String realCause;
    private final Collection<?> source;
    private final LocalDateTime time;

}
