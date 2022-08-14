package ru.dawgg.reportbuilderapi.model.validator;

import static ru.dawgg.reportbuilderapi.util.MatchingUtil.ALLOWS_TYPES;
import static ru.dawgg.reportbuilderapi.util.MatchingUtil.ALLOWS_TYPES_ALIASES_REGEX;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import ru.dawgg.reportbuilderapi.exception.InvalidColumnTypeNameException;
import ru.dawgg.reportbuilderapi.model.annotation.ValidColumnTypeName;

public class ValidColumnTypeNameValidator implements ConstraintValidator<ValidColumnTypeName, String> {

    @Override
    public boolean isValid(String columnTypeName, ConstraintValidatorContext context) {

        var isInAllowedTypes = ALLOWS_TYPES.stream()
                .anyMatch(type -> type.equalsIgnoreCase(columnTypeName));
        var isMatchToAliasesRegex = ALLOWS_TYPES_ALIASES_REGEX.stream()
                        .anyMatch(regex -> columnTypeName.toLowerCase().matches(regex));

        if(isInAllowedTypes || isMatchToAliasesRegex) return true;

        throw new InvalidColumnTypeNameException(
                context.getDefaultConstraintMessageTemplate() + ": " + columnTypeName);
    }

}
