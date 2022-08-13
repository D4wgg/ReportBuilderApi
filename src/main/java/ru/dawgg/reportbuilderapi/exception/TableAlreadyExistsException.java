package ru.dawgg.reportbuilderapi.exception;

import javax.validation.ConstraintDeclarationException;

public class TableAlreadyExistsException extends ConstraintDeclarationException {

    public TableAlreadyExistsException(String message) {
        super(message);
    }

}
