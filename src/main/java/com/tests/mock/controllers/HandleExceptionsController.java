package com.tests.mock.controllers;

import com.tests.mock.esceptions.ElemenAlreadyExistsException;
import com.tests.mock.esceptions.ElementNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice(annotations = RestController.class)
@Log4j2
public class HandleExceptionsController {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?>validationHandler(MethodArgumentNotValidException ex){
        Map<String,String> errors = ex.getFieldErrors().stream()
                .collect(Collectors.toMap(
                        error -> error.getObjectName(),
                        error -> error.getDefaultMessage()
                ));
        log.info(errors);
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> alreadyexistExceptions (ElemenAlreadyExistsException ex){
        log.info(ex.getMessage()+ ": "+ex.getCause());
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> elementNotFound (ElementNotFoundException ex){
        log.info(ex.getMessage()+ ": "+ex.getCause());
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
