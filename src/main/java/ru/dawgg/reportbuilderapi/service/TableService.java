package ru.dawgg.reportbuilderapi.service;

import ru.dawgg.reportbuilderapi.model.table.Table;

public interface TableService {
    void create(Table table);
    void removeByName(String name);
    Table getByName(String tableName);
}
