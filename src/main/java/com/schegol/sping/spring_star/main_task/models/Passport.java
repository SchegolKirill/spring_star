package com.schegol.sping.spring_star.main_task.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "passport")
@NoArgsConstructor
@AllArgsConstructor
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id")
    private Integer id;

    @Column(name = "series")
    private String series;

    @Column(name = "number")
    private String number;

    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;
}
