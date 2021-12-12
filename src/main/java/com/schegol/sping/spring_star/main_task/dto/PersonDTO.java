package com.schegol.sping.spring_star.main_task.dto;

import lombok.*;

@Data
public class PersonDTO {
    private String name;
    private String surname;
    private String patronymic;
    private Integer age;
    private PassportDTO passport;
}
