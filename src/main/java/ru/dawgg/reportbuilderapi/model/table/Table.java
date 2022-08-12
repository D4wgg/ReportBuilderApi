package ru.dawgg.reportbuilderapi.model.table;

import lombok.*;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Value
@Builder
public class Table {
    @NotEmpty(message = "table name cant be an empty")
    String tableName;
    Integer columnsAmount;
    String primaryKey;
    @Size(min = 1)
    List<ColumnInfo> columnInfos;

    @AssertTrue(message = "columnAmount must be equal to columnInfos size")
    private boolean isColumnAmountEqualsColumnListSize() {
        return columnsAmount == columnInfos.size();
    }
}
