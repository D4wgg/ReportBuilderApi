package ru.dawgg.reportbuilderapi.model.table;

import javax.validation.constraints.Pattern;
import lombok.*;

import javax.validation.constraints.NotBlank;
import ru.dawgg.reportbuilderapi.RegexUtil;
import ru.dawgg.reportbuilderapi.model.table.annotation.ValidFieldName;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColumnInfo {

    @ValidFieldName(message = "Invalid column name")
    @NotBlank(message = "column should have a title")
    String title;

    @Pattern(regexp = RegexUtil.COLUMN_TYPE_REGEX, message = "Invalid column type")
    @NotBlank(message = "column should have a type")
    String type;
}
