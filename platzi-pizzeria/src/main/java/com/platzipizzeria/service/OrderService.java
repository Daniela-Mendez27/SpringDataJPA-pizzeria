package com.platzipizzeria.service;


import com.platzipizzeria.persistence.entity.OrderEntity;
import com.platzipizzeria.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> getAll() {
        List<OrderEntity> orders = orderRepository.findAll();
        orders.forEach(o-> System.out.println(o.getCustomer().getName()) );
        return this.orderRepository.findAll();
    }
}
