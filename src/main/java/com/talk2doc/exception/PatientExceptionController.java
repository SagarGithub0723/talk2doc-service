package com.talk2doc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PatientExceptionController {

    @ExceptionHandler(value = PatientException.class)
    public ResponseEntity<Object> exception (PatientException exception) {
        return new ResponseEntity<>("Patient not found", HttpStatus.NOT_FOUND);
    }
}
