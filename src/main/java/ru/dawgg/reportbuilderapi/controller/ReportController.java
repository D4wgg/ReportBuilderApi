package ru.dawgg.reportbuilderapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dawgg.reportbuilderapi.model.report.Report;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    @GetMapping("/get-report-by-id/{id}")
    public Report getReportById(@PathVariable("id") Integer id) {
        return null;
    }

    @PostMapping("/create-report")
    public ResponseEntity.BodyBuilder createReport(@RequestBody Report report) {
//        service.save(report);
        return ResponseEntity.ok();
    }
}
