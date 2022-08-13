package ru.dawgg.reportbuilderapi.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.dawgg.reportbuilderapi.exception.TableAlreadyExistsException;
import ru.dawgg.reportbuilderapi.model.annotation.UniqueTableName;
import ru.dawgg.reportbuilderapi.repository.TableRepository;

@Component
@RequiredArgsConstructor
public class UniqueTableNameValidator implements ConstraintValidator<UniqueTableName, String> {
    private final TableRepository tableRepository;

    @Override
    public boolean isValid(String tableName, ConstraintValidatorContext context) {
        if(tableRepository.isExist(tableName)) {
            throw new TableAlreadyExistsException("Table already exists");
        }

        return true;
    }

}
