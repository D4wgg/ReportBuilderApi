package ru.dawgg.reportbuilderapi.controller;

import static org.springframework.http.HttpStatus.CREATED;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dawgg.reportbuilderapi.model.report.ReportRequest;
import ru.dawgg.reportbuilderapi.model.report.ReportResponse;
import ru.dawgg.reportbuilderapi.service.ReportService;

@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
@Validated
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/get-report-by-id/{id}")
    public ResponseEntity<ReportResponse> getReportById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(reportService.getById(id));
    }

    @PostMapping("/create-report")
    public ResponseEntity<Void> createReport(@RequestBody @Valid ReportRequest reportRequest) {
        reportService.create(reportRequest);
        return new ResponseEntity<>(CREATED);
    }
}
