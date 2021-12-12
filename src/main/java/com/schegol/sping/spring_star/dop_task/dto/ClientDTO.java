package com.schegol.sping.spring_star.dop_task.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {
    private String name;
    private String inn;
    private String phoneNumber;
    private AddressDTO addressDTO;
    private List<OrderDTO> ordersDTO;
}
