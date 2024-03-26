package org.example.projects.tictactoe.exception;

public class InavlidPlayerSizeException extends RuntimeException{
    public InavlidPlayerSizeException() {
    }

    public InavlidPlayerSizeException(String message) {
        super(message);
    }

    public InavlidPlayerSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InavlidPlayerSizeException(Throwable cause) {
        super(cause);
    }

    public InavlidPlayerSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
