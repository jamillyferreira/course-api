package com.jamillyferreira.api.course.repository;

import com.jamillyferreira.api.course.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
