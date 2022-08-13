package ru.dawgg.reportbuilderapi.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import ru.dawgg.reportbuilderapi.RegexUtil;
import ru.dawgg.reportbuilderapi.exception.InvalidIdException;
import ru.dawgg.reportbuilderapi.model.annotation.ValidId;

public class ValidIdValidator implements ConstraintValidator<ValidId, Integer> {

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext context) {

        if(!id.toString().matches(RegexUtil.ID_REGEX)) {
            throw new InvalidIdException(context.getDefaultConstraintMessageTemplate() + ": " + id);
        }

        return true;
    }

}