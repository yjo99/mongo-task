package com.sarmad.task.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException ex) {
        log.error( "Thread [" + Thread.currentThread().getId() + "] | Custom Exception : " + ex);
        ex.printStackTrace();
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleGlobalException(Exception ex) {
        log.error( "Thread [" + Thread.currentThread().getId() + "] | Exception : " + ex);
        ex.printStackTrace();
        return (ResponseEntity) ResponseEntity.internalServerError();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException ex) {
        log.error( "Thread [" + Thread.currentThread().getId() + "] | Exception : " + ex);
        ex.printStackTrace();
        return (ResponseEntity) ResponseEntity.internalServerError();
    }

    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public ResponseEntity<Object> handleInternalAuthenticationServiceException(InternalAuthenticationServiceException ex) {
        log.error( "Thread [" + Thread.currentThread().getId() + "] | Internal Authentication Service Exception : " + ex);
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException ex) {
        log.error( "Thread [" + Thread.currentThread().getId() + "] | BadCredentials Service Exception : " + ex);
        return ResponseEntity.ok("Invalid Login Id or Password");    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        // Use StringBuilder to accumulate error messages
        StringBuilder errorMessages = new StringBuilder();

        // Iterate over all validation errors
        e.getBindingResult().getAllErrors().forEach(error -> {
            // Default to the object name for errors that are not FieldError
            String fieldName = error instanceof FieldError ? ((FieldError) error).getField() : error.getObjectName();
            String message = error.getDefaultMessage();

            // Append the error message to the StringBuilder
            errorMessages.append(String.format("%s: %s%n", fieldName, message));
        });

        // Create the error map and return it with BAD_REQUEST status
        String errorMessage = errorMessages.toString().trim();
        return new ResponseEntity<>(splitErrors(errorMessage), HttpStatus.BAD_REQUEST);
    }

    private List<String> splitErrors(String errorString) {

        return Arrays.stream(errorString.split("\\R"))
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .collect(Collectors.toList());
    }
}
