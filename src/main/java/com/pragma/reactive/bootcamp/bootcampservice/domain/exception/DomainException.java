package com.pragma.reactive.bootcamp.bootcampservice.domain.exception;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}