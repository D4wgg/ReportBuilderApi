package ru.dawgg.reportbuilderapi.service.impl;

import lombok.RequiredArgsConstructor;
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

}
