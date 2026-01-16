package com.jamillyferreira.api.course.repository;

import com.jamillyferreira.api.course.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
