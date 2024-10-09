package com.example.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

public class ExceptionResponse extends RuntimeException{

    protected final int code;
    protected final String message;
    protected final String value;

    public ExceptionResponse(HttpStatus status, String messageUrl, @Nullable String value, Object ...arg){
        this.code = status.value();
        this.message = messageUrl;
        this.value = value;
    }

    public ExceptionResponse(int code, String messageUrl, @Nullable String value, Object ...arg){
        this.code = code;
        this.message = messageUrl;
        this.value = value;
    }
}
