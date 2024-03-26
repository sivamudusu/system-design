package org.example.projects.parkinglot.exception;

public class BillNotFoundException extends RuntimeException{
    public BillNotFoundException() {
    }

    public BillNotFoundException(String message) {
        super(message);
    }
}
