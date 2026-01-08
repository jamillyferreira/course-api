package com.jamillyferreira.api.course.repository;

import com.jamillyferreira.api.course.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
