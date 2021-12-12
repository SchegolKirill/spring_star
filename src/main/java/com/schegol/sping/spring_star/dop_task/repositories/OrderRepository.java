package com.schegol.sping.spring_star.dop_task.repositories;

import com.schegol.sping.spring_star.dop_task.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
