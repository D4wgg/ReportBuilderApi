package ru.dawgg.reportbuilderapi.service;

import org.springframework.http.ResponseEntity;
import ru.dawgg.reportbuilderapi.model.query.SingleQuery;

import java.util.List;

public interface SingleQueryService {
    void save(SingleQuery singleQuery);
    void update(SingleQuery singleQuery);
    void deleteById(Integer id);
    void executeById(Integer id);
    SingleQuery findById(Integer id);
    List<SingleQuery> findAll();
}
