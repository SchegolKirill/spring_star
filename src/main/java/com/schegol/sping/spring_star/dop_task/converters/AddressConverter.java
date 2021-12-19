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
        dto.setCodeOfRegion(address.getCodeOfRegion());
        dto.setNameOfDistrict(address.getNameOfDistrict());
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


    public Address DTOToEntity(AddressDTO dto){

        Address address = new Address();
        address.setCodeOfRegion(dto.getCodeOfRegion());
        address.setNameOfDistrict(dto.getNameOfDistrict());
        address.setNameOfCity(dto.getNameOfCity());
        address.setStreet(dto.getStreet());
        address.setHouse(dto.getHouse());
        address.setCaseNumber(dto.getCaseNumber());
        address.setOffice(dto.getOffice());

        return address;
    }

    public List<Address> DTOToEntity(List<AddressDTO> dto){
        return dto.stream().map(x -> DTOToEntity(x)).collect(Collectors.toList());
    }
}
