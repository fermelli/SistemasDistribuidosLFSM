package com.fermelli.alumnos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)  
public class EmptyUserDataAccessException extends RuntimeException {

    public EmptyUserDataAccessException(String message) {
        super(message);
    }

}