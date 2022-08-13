package ru.dawgg.reportbuilderapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dawgg.reportbuilderapi.exception.NoSuchTableException;
import ru.dawgg.reportbuilderapi.model.query.TableQuery;
import ru.dawgg.reportbuilderapi.repository.TableQueryRepository;
import ru.dawgg.reportbuilderapi.repository.TableRepository;
import ru.dawgg.reportbuilderapi.service.TableQueryService;

@Service
@RequiredArgsConstructor
public class TableQueryServiceImpl implements TableQueryService {

    private final TableRepository tableRepository;
    private final TableQueryRepository tableQueryRepository;

    @Override
    public void createTableQuery(TableQuery request) {
        var tableName = request.getTableName();
        if(tableRepository.isExist(tableName)) {
            tableQueryRepository.save(request);
        } else throw new NoSuchTableException("No such table: " + tableName);
    }

}
