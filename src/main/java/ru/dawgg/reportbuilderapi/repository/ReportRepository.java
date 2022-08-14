package ru.dawgg.reportbuilderapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dawgg.reportbuilderapi.model.report.Report;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {

}
