package com.projectstreamer.moviesservice.exception.handler;

import com.projectstreamer.moviesservice.exception.ExceptionResponse;
import com.projectstreamer.moviesservice.exception.exceptions.CustomException;
import com.projectstreamer.moviesservice.exception.exceptions.CustomNotFoundException;
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
