package ru.dawgg.reportbuilderapi;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RegexUtil {

    /** Any letter, digit(not first), _ (not first or last) */
    public static final String FIELD_NAME_REGEX = "^[^_0-9][_a-zA-Z0-9]+[^_]$";

    /** Any letter, digit(not first), () (not first) */
    public static final String COLUMN_TYPE_REGEX = "^[^0-9()][a-zA-Z(0-9)]+$";
}
