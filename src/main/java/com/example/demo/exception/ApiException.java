package com.example.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ApiException extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NonSaved.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "NON_SAVED")
    public HttpEntity<Object> notSaved(
            HttpMediaTypeNotAcceptableException ex,
            HttpHeaders headers, HttpStatus status,
            WebRequest request) {

        return new HttpEntity<>(get(ex.getMessage(),ex, status.value()));
    }

    private HttpEntity get(String message, Throwable ex, int status) {
        Message m = new Message(false, message, status);
        log.error(message);
        return new HttpEntity<>(m);
    }
}
