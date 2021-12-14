package com.bridgelabs.employeepayrollapp2.exception;

import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.validation.UnexpectedTypeException;
import java.util.NoSuchElementException;
/*****************************************************************************************************************************
 * @Author:PALLAVI
 * @since:8-12-21
 * @version:2.0.1
 **************************************************************************************************************************/
@ControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException) {
        return new ResponseEntity<String>("input fields are empty,please look into it", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> NoSuchElementException(EmptyResultDataAccessException emptyResultDataAccessException) {
        return new ResponseEntity<String>("no value is present in DB,please change your request ", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchMethodException.class)
    public ResponseEntity<String> NoSuchElementException(NoSuchMethodException noSuchMethodException) {
        return new ResponseEntity<String>("no methode is present ,please change your request", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> NoSuchElementException(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<String>("no value is present ,please change your request", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<String> NoSuchElementException(UnexpectedTypeException unexpectedTypeException) {
        return new ResponseEntity<String>(" ,please change your request", HttpStatus.NOT_ACCEPTABLE);

    }

}