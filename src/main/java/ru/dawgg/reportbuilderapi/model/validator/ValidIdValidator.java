package ru.dawgg.reportbuilderapi.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import ru.dawgg.reportbuilderapi.util.MatchingUtil;
import ru.dawgg.reportbuilderapi.exception.InvalidIdException;
import ru.dawgg.reportbuilderapi.model.annotation.ValidId;

public class ValidIdValidator implements ConstraintValidator<ValidId, Long> {

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {

        if(!id.toString().matches(MatchingUtil.ID_REGEX)) {
            throw new InvalidIdException(context.getDefaultConstraintMessageTemplate() + ": " + id);
        }

        return true;
    }

}
