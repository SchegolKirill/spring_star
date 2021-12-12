package com.schegol.sping.spring_star.dop_task.converters;

import com.schegol.sping.spring_star.dop_task.dto.AddressDTO;
import com.schegol.sping.spring_star.dop_task.entity.Address;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressConverter {

    public AddressDTO entityToDTO(Address address){

        AddressDTO dto = new AddressDTO();
        dto.setNameOfCity(address.getNameOfCity());
        dto.setStreet(address.getStreet());
        dto.setHouse(address.getHouse());
        dto.setCaseNumber(address.getCaseNumber());
        dto.setOffice(address.getOffice());

        return dto;
    }

    public List<AddressDTO> entityToDTO(List<Address> addresses){
        return addresses.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

}
