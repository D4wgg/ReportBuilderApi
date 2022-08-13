package ru.dawgg.reportbuilderapi.model.table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import ru.dawgg.reportbuilderapi.model.annotation.UniqueTableName;
import ru.dawgg.reportbuilderapi.model.annotation.ValidFieldName;

@Value
@Builder
@JsonInclude(Include.NON_NULL)
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
