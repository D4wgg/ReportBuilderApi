package ru.dawgg.reportbuilderapi.controller;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dawgg.reportbuilderapi.model.query.TableQuery;

import java.util.List;
import ru.dawgg.reportbuilderapi.service.TableQueryService;

@RestController
@RequestMapping("/api/table-query")
@RequiredArgsConstructor
public class TableQueryController {

    private final TableQueryService tableQueryService;

    @PostMapping("/add-new-query-to-table")
    public ResponseEntity<Void> addNewQuery(@RequestBody TableQuery tableQuery) {
        tableQueryService.create(tableQuery);
        return new ResponseEntity<>(CREATED);
    }

    @PutMapping("/modify-query-in-table")
    public ResponseEntity<Void> modifyQueryInTable(@RequestBody TableQuery tableQuery) {
        tableQueryService.update(tableQuery);
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/delete-table-query-by-id/{id}")
    public ResponseEntity<Void> deleteTableQuery(@PathVariable Long id) {
        tableQueryService.removeById(id);
        return new ResponseEntity<>(ACCEPTED);
    }

    @GetMapping("/execute-table-query-by-id/{id}")
    public ResponseEntity<Void> executeTableQueryById(@PathVariable Long id) {
        tableQueryService.executeById(id);
        return new ResponseEntity<>(CREATED);
    }

    @GetMapping("/get-all-queries-by-table-name/{name}")
    public ResponseEntity<List<TableQuery>> getAllQueriesByTableName(@PathVariable String name) {
        return ResponseEntity.ok(tableQueryService.getAllByTableName(name));
    }

    @GetMapping("/get-table-query-by-id/{id}")
    public TableQuery getQueryById(@PathVariable Long id) {
        return tableQueryService.getById(id);
    }

    @GetMapping("/get-all-table-queries")
    public List<TableQuery> getAllTableQueries() {
        return tableQueryService.getAll();
    }


}
