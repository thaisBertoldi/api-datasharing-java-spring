package com.abserver.datasharing.controller.exception;

import com.abserver.datasharing.service.exception.AddressRepeatedException;
import com.abserver.datasharing.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException objectException) {

        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), objectException.getMessage(),
            System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> ValidException(MethodArgumentNotValidException objectException) {

        ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(),"Validation error !", System.currentTimeMillis());

        for (FieldError fe : objectException.getBindingResult().getFieldErrors()) {
            error.AddErrors(fe.getField(), fe.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(AddressRepeatedException.class)
    public ResponseEntity<StandardError> addressRepeatedException(AddressRepeatedException objectException) {

        StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), objectException.getMessage(),
            System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }

}
