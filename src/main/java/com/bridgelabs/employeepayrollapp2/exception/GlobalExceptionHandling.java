package com.bridgelabs.employeepayrollapp2.exception;

import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.validation.UnexpectedTypeException;
import java.util.NoSuchElementException;
/**
 * Purpose : This class is major class for handling the all exception which can be thrown
 * while the application is running in the server side, as this is the global exception handler
 *
 * @author pallavi jagtap
 * @version : 0.0.1-SNAPSHOT
 * @since 2021-12-06
 */
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
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>("please change http methode type ", HttpStatus.NOT_FOUND);

    }

}