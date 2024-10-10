package com.example.core.exception;

import com.example.core.utils.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(ExceptionResponse.class)
    protected ResponseEntity<Object> handleException (ExceptionResponse exception){
        return ResponseEntity.ok(ResponseObject.buildException(HttpStatus.OK.value()));
    }
}
