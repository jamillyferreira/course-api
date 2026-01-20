package com.jamillyferreira.api.course.service;

import com.jamillyferreira.api.course.domain.User;
import com.jamillyferreira.api.course.repository.UserRepository;
import com.jamillyferreira.api.course.service.exceptions.DatabaseException;
import com.jamillyferreira.api.course.service.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
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
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        user.setId(null); // Verifica se ID esta vazio
        try { // Se tiver vazio, tenta criar um user novo
            return repository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    public void delete(Long id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation: Cannot delete user with associated records");

        }
    }

    public User update(Long id, User user) {
        try {
            User entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(id));
            updateData(entity, user);
            return repository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }


}
