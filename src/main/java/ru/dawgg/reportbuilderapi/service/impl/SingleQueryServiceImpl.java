package ru.dawgg.reportbuilderapi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.dawgg.reportbuilderapi.exception.InvalidSingleQueryIdException;
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
    public void save(SingleQuery singleQuery) {
        repository.save(singleQuery);
    }

    @Override
    public void update(SingleQuery singleQuery) {
        save(singleQuery);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void executeById(Integer id) {
        var singleQuery = findById(id);
        template.execute(singleQuery.getQuery());
    }

    @Override
    @SneakyThrows
    public SingleQuery findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new InvalidSingleQueryIdException("Query with the id has not been found"));
    }

    @Override
    public List<SingleQuery> findAll() {
        return repository.findAll();
    }
}
