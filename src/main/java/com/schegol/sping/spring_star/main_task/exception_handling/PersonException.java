package com.schegol.sping.spring_star.main_task.exception_handling;

public class PersonException extends RuntimeException{

    private ExceptionVariant exceptionVariant;

    public PersonException(String message) {
        super(message);
    }
}
