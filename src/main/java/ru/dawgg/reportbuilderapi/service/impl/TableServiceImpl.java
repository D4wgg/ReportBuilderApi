package ru.dawgg.reportbuilderapi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.dawgg.reportbuilderapi.model.table.Table;
import ru.dawgg.reportbuilderapi.repository.TableRepository;
import ru.dawgg.reportbuilderapi.service.TableService;

@Service
@RequiredArgsConstructor
public class TableServiceImpl implements TableService {

    private final TableRepository tableRepository;

    @Override
    public void createTable(Table table) {
        tableRepository.createTable(table);
    }

    @Override
    public void dropTable(String name) {
        tableRepository.dropTable(name);
    }

    @Override
    @SneakyThrows
    public Table getTableByName(String tableName) {
        return tableRepository.findTableByName(tableName);
    }

}
