package ru.dawgg.reportbuilderapi.repository;

import java.util.List;
import ru.dawgg.reportbuilderapi.model.table.Table;

public interface TableRepository {
    void create(Table table);
    Table findByName(String tableName);
    List<String> findAll();
    boolean isExist(String name);
    void removeByName(String name);
}
