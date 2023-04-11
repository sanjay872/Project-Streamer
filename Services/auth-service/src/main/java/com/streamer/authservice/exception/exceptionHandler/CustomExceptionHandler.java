package com.streamer.authservice.exception.exceptionHandler;

import com.streamer.authservice.exception.exceptions.CustomException;
import com.streamer.authservice.exception.exceptions.CustomNotFoundException;
import com.streamer.authservice.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> customResponse(CustomException ex){
        ExceptionResponse res=new ExceptionResponse();
        res.setStatus(HttpStatus.BAD_REQUEST.value());
        res.setMessage(ex.getMessage());
        res.setTimeStamp(new Date());
        return new ResponseEntity<ExceptionResponse>(res,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> customNotFoundResponse(CustomNotFoundException ex){
        ExceptionResponse res=new ExceptionResponse();
        res.setStatus(HttpStatus.NOT_FOUND.value());
        res.setMessage(ex.getMessage());
        res.setTimeStamp(new Date());
        return new ResponseEntity<ExceptionResponse>(res,HttpStatus.NOT_FOUND);
    }
}
