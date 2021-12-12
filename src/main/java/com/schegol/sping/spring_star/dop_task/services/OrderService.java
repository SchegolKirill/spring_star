package com.schegol.sping.spring_star.dop_task.services;


import com.schegol.sping.spring_star.dop_task.entity.Order;

import java.util.List;

public interface OrderService {
    void createOrder(Order order, Integer clientId);
    Order getOrder(Integer orderId);
    void updateOrder(Order order, Integer orderId);
    List<Order> getOrders(Integer clientId);
    void deleteOrder(Integer orderId);
}
