package com.schegol.sping.spring_star.dop_task.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code_of_region")
    private String codeOfRegion;

    @Column(name = "name_of_district")
    private String nameOfDistrict;

    @Column(name = "name_of_city")
    private String nameOfCity;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private Integer house;

    @Column(name = "case_number")
    private Integer caseNumber;

    @Column(name = "office")
    private Integer office;
}
