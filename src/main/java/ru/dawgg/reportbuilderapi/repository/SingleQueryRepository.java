package ru.dawgg.reportbuilderapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dawgg.reportbuilderapi.model.query.SingleQuery;

public interface SingleQueryRepository extends JpaRepository<SingleQuery, Integer> {
}
