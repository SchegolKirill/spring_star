package com.schegol.sping.spring_star.dop_task.converters;

import com.schegol.sping.spring_star.dop_task.dto.OrderDTO;
import com.schegol.sping.spring_star.dop_task.entity.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderConverter {

    public OrderDTO entityToDTO(Order order){

        OrderDTO dto = new OrderDTO();
        dto.setNumber(order.getNumber());
        dto.setDescription(order.getDescription());
        dto.setDateOfCreation(order.getDateOfCreation());
        dto.setSum(order.getSum());

        return dto;
    }

    public List<OrderDTO> entityToDTO(List<Order> orders){
        return orders.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }
}
