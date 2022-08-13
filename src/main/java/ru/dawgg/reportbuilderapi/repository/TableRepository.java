package ru.dawgg.reportbuilderapi.repository;

import ru.dawgg.reportbuilderapi.model.table.Table;

public interface TableRepository {
    void createTable(Table table);
    boolean isExist(String name);
    void dropTable(String name);
}
