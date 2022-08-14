package ru.dawgg.reportbuilderapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dawgg.reportbuilderapi.model.query.SingleQuery;

@Repository
public interface SingleQueryRepository extends CrudRepository<SingleQuery, Integer> {

}
