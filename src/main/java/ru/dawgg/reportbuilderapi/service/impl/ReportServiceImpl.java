package ru.dawgg.reportbuilderapi.service.impl;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dawgg.reportbuilderapi.exception.ReportAlreadyExistsException;
import ru.dawgg.reportbuilderapi.exception.ReportNotFoundException;
import ru.dawgg.reportbuilderapi.exception.TableNotFoundException;
import ru.dawgg.reportbuilderapi.model.report.Report;
import ru.dawgg.reportbuilderapi.model.report.ReportRequest;
import ru.dawgg.reportbuilderapi.model.report.ReportResponse;
import ru.dawgg.reportbuilderapi.model.table.Table;
import ru.dawgg.reportbuilderapi.repository.ReportRepository;
import ru.dawgg.reportbuilderapi.repository.TableRepository;
import ru.dawgg.reportbuilderapi.service.ReportService;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final TableRepository tableRepository;

    @Override
    public void create(ReportRequest reportRequest) {
        if(reportRepository.existsById(reportRequest.getReportId()))
            throw new ReportAlreadyExistsException("Report with id:" + reportRequest.getReportId() + " already exists");

        var tableNames = reportRequest.getTables().stream()
                .map(Table::getTableName)
                .peek(name -> {
                    if(!tableRepository.isExist(name))
                        throw new TableNotFoundException("No table with name: " + name);
                })
                .toList();

        reportRepository.save(Report.builder()
                .id(reportRequest.getReportId())
                .tableAmount(reportRequest.getTableAmount())
                .tableNames(tableNames)
                .build()
        );
    }

    @Override
    public ReportResponse getById(Long id) {
        var report = reportRepository.findById(id)
                .orElseThrow(() -> new ReportNotFoundException("No report with id: " + id));

        var tables = report.getTableNames().stream()
                .map(name -> Optional.of(tableRepository.findByName(name))
                        .orElseThrow(() -> new TableNotFoundException("No table with name: " + name)))
                .toList();

        return ReportResponse.builder()
                .reportId(String.valueOf(report.getId()))
                .tableAmount(report.getTableAmount())
                .tables(tables)
                .build();
    }

}
