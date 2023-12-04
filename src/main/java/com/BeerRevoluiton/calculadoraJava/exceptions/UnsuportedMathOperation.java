package com.BeerRevoluiton.calculadoraJava.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// vai retornar um response de " BAD REQUEST " REQUISICAO MAL FEITA
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperation extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public UnsuportedMathOperation(String ex) {
        super(ex);
    }
}
