package ru.dawgg.reportbuilderapi.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RegexUtil {

    public static final String FIELD_NAME_REGEX = "[a-zA-Z]{1}[a-zA-Z0-9_]{0,49}";
    public static final String COLUMN_TYPE_REGEX = "^[^0-9()][a-zA-Z(0-9)]+$";
    public static final String ID_REGEX = "[1-9]{1}[0-9]{0,49}";
}
