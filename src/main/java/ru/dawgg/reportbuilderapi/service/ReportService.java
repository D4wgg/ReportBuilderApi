package ru.dawgg.reportbuilderapi.service;

import ru.dawgg.reportbuilderapi.model.report.Report;
import ru.dawgg.reportbuilderapi.model.report.ReportRequest;
import ru.dawgg.reportbuilderapi.model.report.ReportResponse;

public interface ReportService {
    void create(ReportRequest reportRequest);
    ReportResponse getById(Long id);
}
