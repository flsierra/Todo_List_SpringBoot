package com.example.Todo_List.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<ApiException> handleNotValueExeption(ApiRequestException e){
        ApiException exception = new ApiException(e.getStatusCode(),e.getMessage());
        return new ResponseEntity<ApiException>(exception, HttpStatus.NOT_FOUND);
    }
}
