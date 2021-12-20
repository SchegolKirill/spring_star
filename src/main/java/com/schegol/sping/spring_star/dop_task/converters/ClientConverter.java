package com.schegol.sping.spring_star.dop_task.converters;

import com.schegol.sping.spring_star.dop_task.dto.ClientDTO;
import com.schegol.sping.spring_star.dop_task.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientConverter {

    @Autowired
    AddressConverter addressConverter;

    public ClientDTO entityToDTO(Client client){

        ClientDTO dto = new ClientDTO();
        dto.setName(client.getName());
        dto.setInn(client.getInn());
        dto.setPhoneNumber(client.getPhoneNumber());
        dto.setAddressDTO(addressConverter.entityToDTO(client.getAddress()));

        return dto;
    }

    public List<ClientDTO> entityToDTO(List<Client> clients){
        return clients.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public Client DTOToEntity(ClientDTO dto){
        Client client = new Client();
        client.setName(dto.getName());
        client.setInn(dto.getInn());
        client.setPhoneNumber(dto.getPhoneNumber());
        client.setAddress(addressConverter.DTOToEntity(dto.getAddressDTO()));
        return client;
    }

    public List<Client> DTOToEntity(List<ClientDTO> dto){
        return dto.stream().map(x -> DTOToEntity(x)).collect(Collectors.toList());
    }
}
