package ru.dawgg.reportbuilderapi.exception;

public class ReportAlreadyExistsException extends RuntimeException {

    public ReportAlreadyExistsException(String message) {
        super(message);
    }

}
