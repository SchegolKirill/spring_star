package com.schegol.sping.spring_star.dop_task.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clients")
@NoArgsConstructor
@AllArgsConstructor()
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "inn")
    private String inn;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Order> orders;

    public Client(String name, String inn, String phoneNumber, Address address, List<Order> orders){
        this.name = name;
        this.inn = inn;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orders = orders;
    }

    public void addOrderToClient(Order order){
        if(orders == null){
            orders = new ArrayList<>();
        }
        orders.add(order);
        order.setClient(this);
    }
}
