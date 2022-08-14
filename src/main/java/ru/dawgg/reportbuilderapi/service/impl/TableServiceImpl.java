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
    public void create(Table table) {
        tableRepository.create(table);
    }

    @Override
    public void removeByName(String name) {
        tableRepository.removeByName(name);
    }

    @Override
    public Table getByName(String tableName) {
        return tableRepository.findByName(tableName);
    }

}
