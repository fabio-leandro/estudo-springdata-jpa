package com.fabio.gymapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ActivityNotFoundException extends Exception{

    public ActivityNotFoundException(String name){
        super(String.format("Activity not found with name -> %s", name));
    }

    public ActivityNotFoundException(Integer id){
        super(String.format("Activity not found with id -> %d", id));
    }
}
