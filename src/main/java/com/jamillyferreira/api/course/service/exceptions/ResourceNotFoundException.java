package com.jamillyferreira.api.course.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id) {
        super("Resource not found. ID " + id);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
