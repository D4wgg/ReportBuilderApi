package ru.dawgg.reportbuilderapi.model.table;

import java.util.Objects;
import javax.validation.Valid;
import lombok.*;

import javax.validation.constraints.*;
import java.util.List;
import ru.dawgg.reportbuilderapi.RegexUtil;
import ru.dawgg.reportbuilderapi.model.table.annotation.UniqueTableName;
import ru.dawgg.reportbuilderapi.model.table.annotation.ValidFieldName;

@Value
@Builder
public class Table {

    @UniqueTableName
    @ValidFieldName(message = "Invalid table name")
    @NotBlank(message = "table name cant be empty")
    String tableName;

    @NotNull(message = "table` columns amount should be specified")
    Integer columnsAmount;

    @NotBlank(message = "table should have a primary key")
    String primaryKey;

    @Valid
    @Size(min = 1)
    List<ColumnInfo> columnInfos;

    @AssertTrue(message = "columnAmount must be equal to columnInfos size")
    private boolean isColumnAmountEqualsColumnListSize() {
        return columnsAmount == columnInfos.size();
    }

    @AssertTrue(message = "columnInfos must contains primaryKey")
    private boolean isColumnInfosContainsPrimaryKey() {
        return columnInfos.stream().anyMatch(columnInfo -> Objects.equals(columnInfo.getTitle(), primaryKey));
    }
}
