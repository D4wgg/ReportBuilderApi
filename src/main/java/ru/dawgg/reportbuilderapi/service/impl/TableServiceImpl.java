package ru.dawgg.reportbuilderapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dawgg.reportbuilderapi.model.table.Table;
import ru.dawgg.reportbuilderapi.service.TableService;

@Service
@RequiredArgsConstructor
public class TableServiceImpl implements TableService {

    private final JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public void createTable(Table table) {
        jdbcTemplate.update("create table ? (? ?, PRIMARY KEY (?))",
                table.getTableName(),
                table.getColumnInfos().get(0).getTitle(),
                table.getColumnInfos().get(0).getType(),
                table.getPrimaryKey());
    }

}
