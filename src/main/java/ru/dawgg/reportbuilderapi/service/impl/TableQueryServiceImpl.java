package ru.dawgg.reportbuilderapi.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Streamable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.dawgg.reportbuilderapi.exception.TableNotFoundException;
import ru.dawgg.reportbuilderapi.exception.TableQueryNotFoundException;
import ru.dawgg.reportbuilderapi.model.query.TableQuery;
import ru.dawgg.reportbuilderapi.repository.TableQueryRepository;
import ru.dawgg.reportbuilderapi.repository.TableRepository;
import ru.dawgg.reportbuilderapi.service.TableQueryService;

@Service
@RequiredArgsConstructor
public class TableQueryServiceImpl implements TableQueryService {

    private final TableRepository tableRepository;
    private final TableQueryRepository tableQueryRepository;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<TableQuery> getAll() {
        return Streamable.of(tableQueryRepository.findAll()).toList();
    }

    @Override
    public TableQuery getById(Long id) {
        return tableQueryRepository.findById(id).get();
    }

    @Override
    public void create(TableQuery tableQuery) {
        var tableName = tableQuery.getTableName();
        if(tableRepository.isExist(tableName)) {
            tableQueryRepository.save(tableQuery);
        } else throw new TableNotFoundException("No such table: " + tableName);
    }

    @Override
    public void update(TableQuery tableQuery) {
        if(isExistsByIdOrThrow(tableQuery.getQueryId())) {
            create(tableQuery);
        }
    }

    @Override
    public void removeById(Long id) {
        if(isExistsByIdOrThrow(id)) {
            tableQueryRepository.deleteById(id);
        }
    }

    @Override
    public void executeById(Long id) {
        if(isExistsByIdOrThrow(id)) {
            var query = tableQueryRepository.findById(id).get();
            jdbcTemplate.execute(query.getQuery());
        }
    }

    @Override
    public List<TableQuery> getAllByTableName(String tableName) {
        return tableRepository.isExist(tableName)
                ? tableQueryRepository.findAllByTableName(tableName)
                : List.of();

    }

    private boolean isExistsByIdOrThrow(Long id) {
        if(tableQueryRepository.existsById(id)) {
            return true;
        } else throw new TableQueryNotFoundException("TableQuery with id: " + id + " - not found");
    }

}
