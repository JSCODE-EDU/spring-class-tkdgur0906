package com.jscode.spring.exception;

import com.jscode.spring.exception.custom.NoParamException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ErrorResponse noParamExHandler(NoParamException e) {
        return new ErrorResponse("BAD", e.getMessage());
    }

}
