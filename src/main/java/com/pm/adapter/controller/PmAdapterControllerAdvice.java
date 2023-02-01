package com.pm.adapter.controller;

import com.pm.adapter.controller.response.ErrorResponse;
import com.pm.adapter.exception.NoAccountFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PmAdapterControllerAdvice {

    @ExceptionHandler(NoAccountFoundException.class)
    public ResponseEntity handleNoAccountFoundException(NoAccountFoundException ex) {
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.toString(), ex.getMessage());

        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

}
