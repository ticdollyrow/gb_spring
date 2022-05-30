package ru.lesson7.lesson7.Exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<AppError> catchResourceNotFoundException(ResourceNotFoundExeption e){
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<AppError> catchExistEntityException(ExistEntityException e){
        return new ResponseEntity<>(new AppError(HttpStatus.CONFLICT.value(), e.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<FieldsValidationError> catchValidationException(ValidationException e) {

        return new ResponseEntity<>(new FieldsValidationError(e.getErrorFieldsMessages()), HttpStatus.BAD_REQUEST);
    }
}
