package ru.dawgg.reportbuilderapi.model.table.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import ru.dawgg.reportbuilderapi.model.table.validator.ValidTableNameValidator;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidTableNameValidator.class)
public @interface ValidFieldName {
    String message() default "Table name already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
