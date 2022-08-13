package ru.dawgg.reportbuilderapi.exception;

import javax.validation.ConstraintDeclarationException;

public class InvalidFieldNameException extends ConstraintDeclarationException {

    public InvalidFieldNameException(String message) {
        super(message);
    }

}
