package com.example.mygithub.exception;

import com.example.mygithub.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    private static final Logger logger = LoggerFactory.getLogger(GlobalHandlerException.class);

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex){
        logger.info("Handling User not found exception", ex);
        return new ResponseEntity<>(new ErrorResponse("User not found"), HttpStatus.NOT_FOUND);
    }
}

