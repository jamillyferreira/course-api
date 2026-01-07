package com.jamillyferreira.api.course.service;

import com.jamillyferreira.api.course.domain.order.Order;
import com.jamillyferreira.api.course.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado!"));
    }
}
