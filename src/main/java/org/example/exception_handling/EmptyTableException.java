package org.example.exception_handling;

public class EmptyTableException extends Exception{
    public EmptyTableException() {
        super("There is no any element in table");
    }

    public EmptyTableException(String message) {
        super(message);
    }
}
