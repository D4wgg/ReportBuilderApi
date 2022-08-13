package ru.dawgg.reportbuilderapi.model.table.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.dawgg.reportbuilderapi.exception.TableAlreadyExistsException;
import ru.dawgg.reportbuilderapi.model.table.annotation.UniqueTableName;

@Component
@RequiredArgsConstructor
public class UniqueTableNameValidator implements ConstraintValidator<UniqueTableName, String> {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean isValid(String tableName, ConstraintValidatorContext context) {

        var tables =
                jdbcTemplate.query("show tables", (rs, rowNum) -> rs.getString("table_name"));
        if(tables.stream().anyMatch(s -> s.equalsIgnoreCase(tableName))) {
            throw new TableAlreadyExistsException("Table already exists");
        }

        return true;
    }

}
