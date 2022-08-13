package ru.dawgg.reportbuilderapi.exception;

public class NoSuchTableException extends RuntimeException{

    public NoSuchTableException(String message) {
        super(message);
    }

}
