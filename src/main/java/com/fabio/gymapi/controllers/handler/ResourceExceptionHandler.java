package com.fabio.gymapi.controllers.handler;

import com.fabio.gymapi.exceptions.ActivityNotFoundException;
import com.fabio.gymapi.exceptions.AssessmentNotFoundException;
import com.fabio.gymapi.exceptions.RegistrationNotFoundException;
import com.fabio.gymapi.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<MessageError> callStudentNotFoundException(StudentNotFoundException e,
                                                                     HttpServletRequest request){

        MessageError err = new MessageError();

        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

    }

    @ExceptionHandler(ActivityNotFoundException.class)
    public ResponseEntity<MessageError> callActivityNotFoundException(ActivityNotFoundException e,
                                                                     HttpServletRequest request){

        MessageError err = new MessageError();

        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

    }

    @ExceptionHandler(RegistrationNotFoundException.class)
    public ResponseEntity<MessageError> callRegistrationNotFoundException(RegistrationNotFoundException e,
                                                                          HttpServletRequest request){
        MessageError err = new MessageError();

        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

    }

    @ExceptionHandler(AssessmentNotFoundException.class)
    public ResponseEntity<MessageError> callAssessmentNotFoundException(AssessmentNotFoundException e,
                                                                          HttpServletRequest request){
        MessageError err = new MessageError();

        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageError> callValidationsException(MethodArgumentNotValidException e,
                                                                     HttpServletRequest request){
        MessageError err = new MessageError();

        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError("There is an error in the field. Field Name: "+ e.getFieldError().getField());
        err.setMessage(e.getFieldError().getDefaultMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);

    }


}
