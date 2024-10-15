package com.example.core.utils;


import com.example.core.exception.ExceptionHandle;
import com.example.core.exception.ExceptionResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Collection;

public class ResponseObject <T> {

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss"
    )
    private LocalDateTime timestamp = LocalDateTime.now();

    private int code;

    private String message;

    private T data;

    private int total;

    public ResponseObject() {
    }

    public ResponseObject(LocalDateTime timestamp, int code, String message, T data, int total) {
        this.timestamp = timestamp;
        this.code = code;
        this.message = message;
        this.data = data;
        this.total = total;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public static <T> ResponseObject<T> build (int code, String message, Object ... args){
        ResponseObject<T> response = new ResponseObject<>();
        response.code = code;
        response.message = message;
        return response;
    }

    public static <T> ResponseObject<T> build (int code, T data){
        ResponseObject<T> response = new ResponseObject<>();
        response.code = HttpStatus.OK.value();
        response.data = data;
        if (data instanceof Collection) {
            response.total = ((Collection) data).size();
        }
        return response;
    }

    public static <T> ResponseObject<T> buildException (int code, String message){
        ResponseObject<T> response = new ResponseObject<>();
        response.code = code;
        response.message = message;

        return response;
    }
}
