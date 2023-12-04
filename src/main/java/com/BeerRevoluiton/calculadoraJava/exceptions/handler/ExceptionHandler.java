package com.BeerRevoluiton.calculadoraJava.exceptions.handler;


import com.BeerRevoluiton.calculadoraJava.exceptions.ExceptionResponse;
import com.BeerRevoluiton.calculadoraJava.exceptions.UnsuportedMathOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

//manipulador de excecoes QUE VAI SER UM CONTROLLER
@ControllerAdvice // CONCENTRA O CONTROLLER DE EXCECOES AQUI
@RestController
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),ex.getMessage(),request.getDescription(false));
                return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UnsuportedMathOperation.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex , WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);

    }

}
