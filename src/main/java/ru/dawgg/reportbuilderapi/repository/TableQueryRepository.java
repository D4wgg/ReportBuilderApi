package ru.dawgg.reportbuilderapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dawgg.reportbuilderapi.model.query.TableQuery;

@Repository
public interface TableQueryRepository extends CrudRepository<TableQuery, Long> {

}
