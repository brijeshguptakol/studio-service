package com.brijesh.studio.business.exceptions;

public class ClassNotFoundException extends RuntimeException {

    public ClassNotFoundException(Long id) {
        super(String.format("Class with Id - {%s}, was not found", id));
    }
}
