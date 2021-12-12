package com.schegol.sping.spring_star.dop_task.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private String nameOfCity;
    private String street;
    private Integer house;
    private Integer caseNumber;
    private Integer office;
}
