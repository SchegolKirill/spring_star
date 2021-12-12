package com.schegol.sping.spring_star.dop_task.converters;

import com.schegol.sping.spring_star.dop_task.dto.RequestOrderDTO;
import com.schegol.sping.spring_star.dop_task.entity.Order;
import com.schegol.sping.spring_star.dop_task.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RequestOrderConverter {

    @Autowired
    ClientRepository clientRepository;

    public RequestOrderDTO entityToDTO(Order order){

        RequestOrderDTO dto = new RequestOrderDTO();
        dto.setNumber(order.getNumber());
        dto.setDateOfCreation(order.getDateOfCreation());
        dto.setDescription(order.getDescription());
        dto.setSum(order.getSum());
        dto.setId(order.getClient().getId());

        return dto;
    }

    public List<RequestOrderDTO> entityToDTO(List<Order> orders){
        return orders.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public Order DTOToEntity(RequestOrderDTO dto){
        Order order = new Order();
        order.setNumber(dto.getNumber());
        order.setDateOfCreation(dto.getDateOfCreation());
        order.setDescription(dto.getDescription());
        order.setSum(dto.getSum());
        order.setClient(clientRepository.findById(dto.getId()).get());

        return order;
    }

    public List<Order> DTOToEntity(List<RequestOrderDTO> dto){
        return dto.stream().map(x -> DTOToEntity(x)).collect(Collectors.toList());
    }
}
