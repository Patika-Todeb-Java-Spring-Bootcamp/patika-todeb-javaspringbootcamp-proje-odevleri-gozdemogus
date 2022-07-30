package com.patika.springbootcamp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    private String details;

    public EntityNotFoundException(String exception) {
        super(exception);

    }
}
