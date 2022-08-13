package ru.dawgg.reportbuilderapi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> save(SingleQuery singleQuery) {
        repository.save(singleQuery);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> update(SingleQuery singleQuery) {
        save(singleQuery);

        return ResponseEntity.ok(singleQuery);
    }

    @Override
    public ResponseEntity<Object> deleteById(Integer id) {
        repository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Object> executeById(Integer id) {
        var singleQuery = findById(id);
        template.execute(singleQuery.getQuery());

        return new ResponseEntity<>(HttpStatus.CREATED);
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
