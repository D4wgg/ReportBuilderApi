package ru.dawgg.reportbuilderapi.model.table.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import ru.dawgg.reportbuilderapi.RegexUtil;
import ru.dawgg.reportbuilderapi.exception.InvalidColumnTypeNameException;
import ru.dawgg.reportbuilderapi.model.table.annotation.ValidColumnTypeName;

public class ValidColumnTypeNameValidator implements ConstraintValidator<ValidColumnTypeName, String> {

    @Override
    public boolean isValid(String columnTypeNameName, ConstraintValidatorContext context) {

        if(!columnTypeNameName.matches(RegexUtil.COLUMN_TYPE_REGEX)) {
            throw new InvalidColumnTypeNameException(
                    context.getDefaultConstraintMessageTemplate() + ": " + columnTypeNameName
            );
        }

        return true;
    }

}
