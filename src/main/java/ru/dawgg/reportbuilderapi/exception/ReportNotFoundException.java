package ru.dawgg.reportbuilderapi.exception;

public class ReportNotFoundException extends RuntimeException{

    public ReportNotFoundException(String message) {
        super(message);
    }

}
