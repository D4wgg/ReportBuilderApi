package ru.dawgg.reportbuilderapi.service;

import ru.dawgg.reportbuilderapi.model.table.Table;

public interface TableService {
    void createTable(Table table);
    void dropTable(String name);
}
