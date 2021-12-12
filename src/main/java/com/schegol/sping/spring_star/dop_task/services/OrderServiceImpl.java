package com.schegol.sping.spring_star.dop_task.services;

import com.schegol.sping.spring_star.dop_task.entity.Order;
import com.schegol.sping.spring_star.dop_task.repositories.ClientRepository;
import com.schegol.sping.spring_star.dop_task.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;

    @Override
    public void createOrder(Order order, Integer clientId) {
        orderRepository.save(order);
        //order.setClient(clientRepository.findById(clientId).get());
        //clientRepository.findById(clientId).get().addOrderToClient(order);
    }

    @Override
    public Order getOrder(Integer orderId) {
        return orderRepository.findById(orderId).get();
    }

    @Override
    public void updateOrder(Order order, Integer orderId) {
        Order newOrder = orderRepository.findById(orderId).get();
        newOrder.setDescription(order.getDescription());
        newOrder.setNumber(order.getNumber());
        newOrder.setSum(order.getSum());
        newOrder.setDateOfCreation(order.getDateOfCreation());
    }

    @Override
    public List<Order> getOrders(Integer clientId) {
        return clientRepository.findById(clientId).get().getOrders();
    }

    @Override
    public void deleteOrder(Integer orderId) {
        orderRepository.delete(orderRepository.findById(orderId).get());
    }
}
