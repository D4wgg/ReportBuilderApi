package ru.dawgg.reportbuilderapi.repository.impl;

import java.sql.JDBCType;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.dawgg.reportbuilderapi.exception.TableNotFoundException;
import ru.dawgg.reportbuilderapi.model.table.ColumnInfo;
import ru.dawgg.reportbuilderapi.model.table.Table;
import ru.dawgg.reportbuilderapi.repository.TableRepository;

@Repository
@RequiredArgsConstructor
public class TableRepositoryImpl implements TableRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<String> findAll() {
        return jdbcTemplate.query("show tables", (rs, rowNum) -> rs.getString("table_name"));
    }

    @Override
    @SneakyThrows
    public Table findByName(String tableName) {

        var tName = tableName.toUpperCase();

        if(findAll().stream().noneMatch(s -> s.equals(tName))) {
            return Table.builder().build();
        }

        List<ColumnInfo> columnsInfos = new LinkedList<>();
        var metaData = jdbcTemplate.getDataSource()
                .getConnection()
                .getMetaData();
        try(var columns = metaData.getColumns(null,null, tName, null);
                var primaryKeys = metaData.getPrimaryKeys(null,null, tName)
        ) {
            while(columns.next()) {
                var columnName = columns.getString("column_name");
                var columnType = JDBCType.valueOf(columns.getInt("data_type")).getName();
                columnsInfos.add(ColumnInfo.builder().title(columnName).type(columnType).build());
            }

            primaryKeys.next();
            var pk = primaryKeys.getString("column_name").toLowerCase();

            return Table.builder()
                    .tableName(tableName)
                    .columnInfos(columnsInfos)
                    .columnsAmount(columnsInfos.size())
                    .primaryKey(pk)
                    .build();
        }
    }

    @Override
    public void create(Table table) {
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
    public boolean isExist(String tableName) {
        return findAll().stream()
                .anyMatch(s -> s.equalsIgnoreCase(tableName));
    }

    @Override
    public void removeByName(String name) {
        if (isExist(name)) {
            jdbcTemplate.execute("drop table " + name);
        } else throw new TableNotFoundException("No such table with name: " + name);
    }
}
