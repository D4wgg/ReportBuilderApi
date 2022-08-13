package ru.dawgg.reportbuilderapi.service;

import org.springframework.http.ResponseEntity;
import ru.dawgg.reportbuilderapi.model.query.SingleQuery;

import java.util.List;

public interface SingleQueryService {
    ResponseEntity<Object> save(SingleQuery singleQuery);
    ResponseEntity update(SingleQuery singleQuery);
    ResponseEntity<Object> deleteById(Integer id);
    ResponseEntity<Object> executeById(Integer id);
    SingleQuery findById(Integer id);
    List<SingleQuery> findAll();
}
