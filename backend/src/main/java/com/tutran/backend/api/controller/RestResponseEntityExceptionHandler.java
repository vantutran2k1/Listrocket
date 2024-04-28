package com.tutran.backend.api.controller;

import com.tutran.backend.api.payload.ApiError;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            EntityExistsException.class,
            EntityNotFoundException.class
    })
    protected ResponseEntity<ApiError> handleBadRequestException(
            final RuntimeException ex,
            final WebRequest request
    ) {
        ApiError response = new ApiError(ex.getLocalizedMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        Map<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(
                camelToSnake(error.getField()),
                error.getDefaultMessage()
        ));

        ApiError response = new ApiError(errors);
        return ResponseEntity.badRequest().body(response);
    }

    private String camelToSnake(String camelCase) {
        StringBuilder snakeCase = new StringBuilder();
        for (int i = 0; i < camelCase.length(); i++) {
            char c = camelCase.charAt(i);
            if (Character.isUpperCase(c)) {
                snakeCase.append("_").append(Character.toLowerCase(c));
            } else {
                snakeCase.append(c);
            }
        }

        if (snakeCase.charAt(0) == '_') {
            snakeCase.deleteCharAt(0);
        }

        return snakeCase.toString();
    }

}
