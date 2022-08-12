package ru.dawgg.reportbuilderapi.model.table;

import javax.validation.constraints.Size;
import java.util.List;

public class Table {
    private String tableName;
    private Integer columnAmount;
    private String primaryKey;
    @Size(min = 1)
    private List<Column> columnList;
}
