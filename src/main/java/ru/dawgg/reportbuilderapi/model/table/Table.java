package ru.dawgg.reportbuilderapi.model.table;

import lombok.*;

import javax.validation.constraints.*;
import java.util.List;

@Value
@Builder
public class Table {
    @NotBlank(message = "table name cant be empty")
    String tableName;
    @NotNull(message = "table` columns amount should be specified")
    Integer columnsAmount;

    @NotBlank(message = "table should have a primary key")
    String primaryKey;
    @Size(min = 1)
    List<ColumnInfo> columnInfos;

    @AssertTrue(message = "columnAmount must be equal to columnInfos size")
    private boolean isColumnAmountEqualsColumnListSize() {
        return columnsAmount == columnInfos.size();
    }
}
