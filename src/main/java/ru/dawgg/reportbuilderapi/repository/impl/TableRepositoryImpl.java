package ru.dawgg.reportbuilderapi.repository.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.dawgg.reportbuilderapi.exception.InvalidFieldNameException;
import ru.dawgg.reportbuilderapi.model.table.ColumnInfo;
import ru.dawgg.reportbuilderapi.model.table.Table;
import ru.dawgg.reportbuilderapi.repository.TableRepository;

@Repository
@RequiredArgsConstructor
public class TableRepositoryImpl implements TableRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void createTable(Table table) {
        jdbcTemplate.execute(
                createTableQuery(table.getTableName(), table.getColumnInfos(), table.getPrimaryKey())
        );
    }

    private String createTableQuery(String name, List<ColumnInfo> columnInfos, String pk) {
        var columns = columnInfos.stream()
                .map(columnInfo -> columnInfo.getTitle() + " " + columnInfo.getType())
                .collect(Collectors.joining(", "));
        return "create table " + name + " (" + columns + ", primary key (" + pk + "))";
    }

    @Override
    public boolean isExist(String name) {
        var tables = jdbcTemplate
                .query("show tables", (rs, rowNum) -> rs.getString("table_name"));
        return tables.stream().anyMatch(s -> s.equalsIgnoreCase(name));
    }

    @Override
    public void dropTable(String name) {
        if (isExist(name)) {
            jdbcTemplate.execute("drop table " + name);
        } else throw new InvalidFieldNameException("The table does not exist");
    }
}
