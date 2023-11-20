package com.example.Todo_List.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class ApiRequestException extends  RuntimeException{

    HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    int statusCode = httpStatus.value();

    public ApiRequestException (String mensaje){
        super(mensaje);
    }
    public ApiRequestException (String mensaje, Throwable cause){
        super(mensaje,cause);
    }

    public int getStatusCode(){
        return statusCode;
    }
}
