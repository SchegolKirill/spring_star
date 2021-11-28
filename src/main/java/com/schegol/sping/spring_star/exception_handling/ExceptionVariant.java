package com.schegol.sping.spring_star.exception_handling;

public enum ExceptionVariant {
    NOT_FOUND("Данный человек не найден"), BAD_REQUEST("Некорректный запрос");

    private String advice;

    ExceptionVariant(String advice){
        this.advice = advice;
    }

    public String getAdvice(){
        return advice;
    }
}
