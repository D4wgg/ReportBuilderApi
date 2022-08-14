package ru.dawgg.reportbuilderapi.util;

import java.sql.JDBCType;
import java.util.Arrays;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MatchingUtil {

    public static final String FIELD_NAME_REGEX = "[a-zA-Z]{1}[a-zA-Z0-9_]{0,49}";
    public static final String ID_REGEX = "[1-9]{1}[0-9]{0,49}";

    public static final List<String> ALLOWS_TYPES =
            Arrays.stream(JDBCType.values()).map(JDBCType::getName).toList();
    public static final List<String> ALLOWS_TYPES_ALIASES_REGEX =
            List.of("int[4,8]?", "varchar(\\([^0]([0-9]+)\\))?");
}
