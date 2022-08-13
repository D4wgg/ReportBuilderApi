package ru.dawgg.reportbuilderapi.model.table.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import ru.dawgg.reportbuilderapi.RegexUtil;
import ru.dawgg.reportbuilderapi.exception.InvalidFieldNameException;
import ru.dawgg.reportbuilderapi.model.table.annotation.ValidFieldName;

public class ValidTableNameValidator implements ConstraintValidator<ValidFieldName, String> {

    @Override
    public boolean isValid(String fieldName, ConstraintValidatorContext context) {

        if(!fieldName.matches(RegexUtil.FIELD_NAME_REGEX)) {
            throw new InvalidFieldNameException(context.getDefaultConstraintMessageTemplate() + ": " + fieldName);
        }

        return true;
    }

}
