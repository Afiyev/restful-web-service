package org.example.exception_handling;

public class ExceptionResponseEntity {
    private String message;

    public ExceptionResponseEntity() {
    }

    public ExceptionResponseEntity(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
