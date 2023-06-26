package com.talk2doc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DoctorExceptionController {

    @ExceptionHandler(value = DoctorException.class)
    public ResponseEntity<Object> exception (DoctorException exception) {
        return new ResponseEntity<>("Doctor not found", HttpStatus.NOT_FOUND);
    }
}
