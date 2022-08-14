package ru.dawgg.reportbuilderapi.util;

import java.sql.JDBCType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MatchingUtil {

    public static final String FIELD_NAME_REGEX = "[a-zA-Z]{1}[a-zA-Z0-9_-]*$";
    public static final String ID_REGEX = "^[1-9][0-9]*$";

    public static final List<String> ALLOWS_TYPES =
            Arrays.stream(JDBCType.values()).map(JDBCType::getName).toList();
    public static final List<String> ALLOWS_TYPES_ALIASES_REGEX =
            List.of("int[4,8]?", "varchar(\\([^0]([0-9]+)\\))?");

    public static final Map<String,String> SQL_STANDARD_TYPES = Map.of(
            "VARCHAR","CHARACTER VARYING"
    );

    public static String replaceWithStandardIfExists(String type) {
        return Optional.ofNullable(SQL_STANDARD_TYPES.get(type.toUpperCase())).orElse(type);
    }

}
