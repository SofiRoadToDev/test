package com.tests.mock.esceptions;

public class ElemenAlreadyExistsException extends RuntimeException{

    public ElemenAlreadyExistsException(String message) {
        super(message);
    }

    public ElemenAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
