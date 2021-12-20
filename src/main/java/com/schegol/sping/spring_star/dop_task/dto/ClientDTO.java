package com.schegol.sping.spring_star.dop_task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private String name;
    private String inn;
    private String phoneNumber;
    private AddressDTO addressDTO;
}
