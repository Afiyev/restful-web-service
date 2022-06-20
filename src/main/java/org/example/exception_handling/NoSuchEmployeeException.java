package org.example.exception_handling;

public class NoSuchEmployeeException extends Exception{
    public NoSuchEmployeeException() {
    }

    public NoSuchEmployeeException(int id) {
        super("There is no element with ID = " + id + " in table");
    }

    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
