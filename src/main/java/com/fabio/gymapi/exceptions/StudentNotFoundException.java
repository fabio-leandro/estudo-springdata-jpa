package com.fabio.gymapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends Exception{

    public StudentNotFoundException(Long id){
        super(String.format("Student not found with id -> %d", id));
    }
    public StudentNotFoundException(String cpf){
        super( String.format("Student not found with cpf -> %s", cpf));
    }
}
