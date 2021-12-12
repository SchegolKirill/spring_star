package com.schegol.sping.spring_star.dop_task.controllers;

import com.schegol.sping.spring_star.dop_task.converters.OrderConverter;
import com.schegol.sping.spring_star.dop_task.converters.RequestOrderConverter;
import com.schegol.sping.spring_star.dop_task.dto.OrderDTO;
import com.schegol.sping.spring_star.dop_task.dto.RequestOrderDTO;
import com.schegol.sping.spring_star.dop_task.entity.Order;
import com.schegol.sping.spring_star.dop_task.services.ClientService;
import com.schegol.sping.spring_star.dop_task.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderConverter orderConverter;
    private final ClientService clientService;
    private final RequestOrderConverter requestOrderConverter;

    @PostMapping("/addneworder")
    public String addNewOrderToClient(@RequestBody RequestOrderDTO order){
        orderService.createOrder(requestOrderConverter.DTOToEntity(order),
                requestOrderConverter.DTOToEntity(order).getId());
        return "Заказ " + requestOrderConverter.DTOToEntity(order).getDescription()
                + " успешно добавлен клиенту " + order.getId();
    }

    @GetMapping("/getorder/{id}")
    public OrderDTO getOrder(@PathVariable("id") Integer id){
        return orderConverter.entityToDTO(orderService.getOrder(id));
    }

    @PutMapping("/updateorder/{id}")
    public String updateOrder(@PathVariable("id") Integer id, @RequestBody Order order){
        orderService.updateOrder(order, id);
        return "Заказ " + id + " успешно обновлен";
    }

    @GetMapping("/getorders/{id}")
    public List<OrderDTO> getOrders(@PathVariable("id") Integer id){
        return orderConverter.entityToDTO(clientService.getClient(id).getOrders());
    }

    @DeleteMapping("/deleteorder/{id}")
    public String deleteOrder(@PathVariable("id")Integer id){
        orderService.deleteOrder(id);
        return "Заказ " + id + "успешно удален";
    }
}
