package com.schegol.sping.spring_star.exception_handling;

public class PersonException extends RuntimeException{

    private ExceptionVariant exceptionVariant;

    public PersonException(String message) {
        super(message);
    }
}
