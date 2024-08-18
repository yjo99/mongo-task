package com.sarmad.task.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.Locale;

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


}
