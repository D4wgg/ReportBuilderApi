package ru.dawgg.reportbuilderapi.controller;

import static org.springframework.http.HttpStatus.CREATED;

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
    public ResponseEntity<Void> addNewQuery(@RequestBody TableQuery request) {
        tableQueryService.createTableQuery(request);
        return new ResponseEntity<>(CREATED);
    }

    @PutMapping("/modify-query-in-table")
    public ResponseEntity.BodyBuilder modifyQueryInTable(@RequestBody TableQuery request) {
//        service.update(query);
        return ResponseEntity.ok();
    }

    @DeleteMapping("/delete-table-query-by-id/{id}")
    public ResponseEntity.BodyBuilder deleteTableQuery(@PathVariable("id") Integer id) {
//        service.deleteById(Integer id);
        return ResponseEntity.ok();
    }

    @GetMapping("/get-all-queries-by-table-name/{name}")
    public List<TableQuery> getAllQueriesByTableName(@PathVariable("name") String name) {
//        return service.findAllByTableName(name);
        return null;
    }

    @GetMapping("/get-table-query_by-id/{id}")
    public TableQuery getQueryById(@PathVariable("id") Integer id) {
//        return service.findById(id);
        return null;
    }

    @GetMapping("/get-all-table-queries")
    public List<TableQuery> getAllTableQueries() {
//        return tableService.findAll()
//                .stream()
//                .flatMap(Table::getQueries);
        return null;
    }


}
