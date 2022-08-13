package ru.dawgg.reportbuilderapi.exception;

import javax.validation.ConstraintDeclarationException;

public class InvalidColumnTypeNameException extends ConstraintDeclarationException {

    public InvalidColumnTypeNameException(String message) {
        super(message);
    }

}
