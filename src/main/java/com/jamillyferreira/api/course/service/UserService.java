package com.jamillyferreira.api.course.service;

import com.jamillyferreira.api.course.domain.User;
import com.jamillyferreira.api.course.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));
    }

    public User insert(User user) {
        user.setId(null);
        return repository.save(user);
    }

    public void delete(Long id) {
        User user = findById(id);
        repository.delete(user);

    }

}
