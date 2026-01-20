package com.jamillyferreira.api.course.controller.execptions;

public class ResourceExceptionHandler extends RuntimeException {
    public ResourceExceptionHandler(String message) {
        super(message);
    }
}
