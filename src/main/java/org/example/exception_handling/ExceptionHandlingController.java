package org.example.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponseEntity> handleException(NoSuchEmployeeException exception){
        ExceptionResponseEntity responseEntity = new ExceptionResponseEntity();
        responseEntity.setMessage(exception.getMessage());
        return new ResponseEntity<>(responseEntity, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponseEntity> handleException(EmptyTableException exception){
        ExceptionResponseEntity responseEntity = new ExceptionResponseEntity();
        responseEntity.setMessage(exception.getMessage());
        return new ResponseEntity<>(responseEntity, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponseEntity> handleException(Exception exception){
        ExceptionResponseEntity responseEntity = new ExceptionResponseEntity();
        responseEntity.setMessage(exception.getMessage());
        return new ResponseEntity<>(responseEntity, HttpStatus.BAD_REQUEST);
    }
}
