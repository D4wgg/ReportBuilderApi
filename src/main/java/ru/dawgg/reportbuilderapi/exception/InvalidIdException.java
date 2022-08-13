package ru.dawgg.reportbuilderapi.exception;

import javax.validation.ConstraintDeclarationException;

public class InvalidIdException extends ConstraintDeclarationException {

    public InvalidIdException(String message) {
        super(message);
    }

}
