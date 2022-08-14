package ru.dawgg.reportbuilderapi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.util.Streamable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.dawgg.reportbuilderapi.exception.SingleQueryAlreadyExistException;
import ru.dawgg.reportbuilderapi.exception.SingleQueryNotFoundException;
import ru.dawgg.reportbuilderapi.model.query.SingleQuery;
import ru.dawgg.reportbuilderapi.repository.SingleQueryRepository;
import ru.dawgg.reportbuilderapi.service.SingleQueryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SingleQueryServiceImpl implements SingleQueryService {

    private final SingleQueryRepository repository;
    private final JdbcTemplate template;

    @Override
    @SneakyThrows
    public void save(SingleQuery singleQuery) {
        if (!repository.existsById(singleQuery.getQueryId())) {
            repository.save(singleQuery);
        } else throw new SingleQueryAlreadyExistException("query with id - " +
                singleQuery.getQueryId() +
                " already exist");
    }

    @Override
    public void update(SingleQuery singleQuery) {
        if (isExistByIdOrThrow(singleQuery.getQueryId())) {
            repository.save(singleQuery);
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (isExistByIdOrThrow(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public void executeById(Integer id) {
        if (isExistByIdOrThrow(id)) {
            var singleQuery = findById(id);
            template.execute(singleQuery.getQuery());
        }
    }

    @Override
    @SneakyThrows
    public SingleQuery findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new SingleQueryNotFoundException("Query with the id has not been found"));
    }

    @Override
    public List<SingleQuery> findAll() {
        return Streamable.of(repository.findAll()).toList();
    }

    @SneakyThrows
    private boolean isExistOrThrow(SingleQuery singleQuery) {
        if (repository.existsByQueryAndQueryId(singleQuery.getQuery(), singleQuery.getQueryId())) {
            return true;
        } else throw new SingleQueryNotFoundException("The query has not been found");
    }

    @SneakyThrows
    private boolean isExistByIdOrThrow(Integer id) {
        if (repository.existsById(id)) {
            return true;
        } else throw new SingleQueryNotFoundException("Query with id - " + id + " has not been found");
    }
}
