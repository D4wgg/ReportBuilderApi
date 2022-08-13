package ru.dawgg.reportbuilderapi.model.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import ru.dawgg.reportbuilderapi.model.validator.ValidTableNameValidator;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidTableNameValidator.class)
public @interface ValidFieldName {
    String message() default "Invalid field name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
