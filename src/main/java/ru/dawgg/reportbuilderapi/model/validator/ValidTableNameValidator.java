package ru.dawgg.reportbuilderapi.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import ru.dawgg.reportbuilderapi.util.MatchingUtil;
import ru.dawgg.reportbuilderapi.exception.InvalidFieldNameException;
import ru.dawgg.reportbuilderapi.model.annotation.ValidFieldName;

public class ValidTableNameValidator implements ConstraintValidator<ValidFieldName, String> {

    @Override
    public boolean isValid(String fieldName, ConstraintValidatorContext context) {

        if(!fieldName.matches(MatchingUtil.FIELD_NAME_REGEX)) {
            throw new InvalidFieldNameException(context.getDefaultConstraintMessageTemplate() + ": " + fieldName);
        }

        return true;
    }

}
