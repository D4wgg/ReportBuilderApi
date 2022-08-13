package ru.dawgg.reportbuilderapi.model.table;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dawgg.reportbuilderapi.model.annotation.ValidColumnTypeName;
import ru.dawgg.reportbuilderapi.model.annotation.ValidFieldName;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColumnInfo {

    @ValidFieldName(message = "Invalid column name")
    @NotBlank(message = "column should have a title")
    String title;

    @ValidColumnTypeName
    @NotBlank(message = "column should have a type")
    String type;
}
