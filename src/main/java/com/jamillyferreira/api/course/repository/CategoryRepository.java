package com.jamillyferreira.api.course.repository;

import com.jamillyferreira.api.course.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
