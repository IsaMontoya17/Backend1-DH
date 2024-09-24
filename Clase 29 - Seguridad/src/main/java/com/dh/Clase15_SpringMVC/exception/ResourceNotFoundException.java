package com.dh.Clase15_SpringMVC.exception;

//creamos nuestra propia excepción
public class ResourceNotFoundException extends RuntimeException {
    //creo un constructor
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
