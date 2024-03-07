package com.beta.replyservice.exception;

import com.beta.replyservice.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = { ValidateException.class })
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleException(ValidateException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
