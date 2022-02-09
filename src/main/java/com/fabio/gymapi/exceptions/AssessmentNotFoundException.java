package com.fabio.gymapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AssessmentNotFoundException extends Exception {

    public AssessmentNotFoundException(Long id){
        super(String.format("Assessment not found with id -> %s", id));
    }
}
