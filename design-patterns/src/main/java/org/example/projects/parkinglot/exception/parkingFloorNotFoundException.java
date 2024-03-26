package org.example.projects.parkinglot.exception;

public class parkingFloorNotFoundException extends RuntimeException{
    public parkingFloorNotFoundException() {
    }

    public parkingFloorNotFoundException(String message) {
        super(message);
    }
}
