package com.fabio.gymapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegistrationNotFoundException extends Exception{

    public RegistrationNotFoundException(Long id){
        super(String.format("The registration not found with id -> %d", id));
    }
}
