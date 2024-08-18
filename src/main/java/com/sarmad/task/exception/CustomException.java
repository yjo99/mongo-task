package com.sarmad.task.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomException extends RuntimeException {
    private final String message;


    public CustomException(String message) {
        super(message);
        this.message = message;
    }
}
