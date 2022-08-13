package ru.dawgg.reportbuilderapi.repository;

import java.sql.SQLException;
import java.util.List;
import ru.dawgg.reportbuilderapi.model.table.Table;

public interface TableRepository {
    void createTable(Table table);
    Table findTableByName(String tableName) throws SQLException;
    List<String> showTables();
    boolean isExist(String name);
    void dropTable(String name);
}
