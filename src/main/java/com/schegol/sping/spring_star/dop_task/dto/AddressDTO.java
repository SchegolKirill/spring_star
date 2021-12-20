package com.schegol.sping.spring_star.dop_task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private String codeOfRegion;
    private String nameOfDistrict;
    private String nameOfCity;
    private String street;
    private Integer house;
    private Integer caseNumber;
    private Integer office;
}
