package ru.dawgg.reportbuilderapi.model.table.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import ru.dawgg.reportbuilderapi.model.table.validator.ValidColumnTypeNameValidator;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidColumnTypeNameValidator.class)
public @interface ValidColumnTypeName {
    String message() default "Invalid column type name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
