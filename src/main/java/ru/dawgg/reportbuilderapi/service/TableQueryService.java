package ru.dawgg.reportbuilderapi.service;

import java.util.List;
import ru.dawgg.reportbuilderapi.model.query.TableQuery;

public interface TableQueryService {
    void create(TableQuery tableQuery);
    void update(TableQuery tableQuery);
    void removeById(Long id);
    void executeById(Long id);
    List<TableQuery> getAllByTableName(String tableName);
    List<TableQuery> getAll();
    TableQuery getById(Long id);
}
