package com.jamillyferreira.api.course.repository;

import com.jamillyferreira.api.course.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
