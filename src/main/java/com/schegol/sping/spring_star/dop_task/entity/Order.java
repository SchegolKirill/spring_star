package com.schegol.sping.spring_star.dop_task.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "date_of_creation")
    private LocalDate dateOfCreation;

    @Column(name = "description")
    private String description;

    @Column(name = "sum")
    private Long sum;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "client_id")
    private Client client;

    public Order(Integer number, LocalDate dateOfCreation, String description, Long sum) {
        this.number = number;
        this.dateOfCreation = dateOfCreation;
        this.description = description;
        this.sum = sum;
    }
}
