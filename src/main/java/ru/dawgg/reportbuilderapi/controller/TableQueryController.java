package ru.dawgg.reportbuilderapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dawgg.reportbuilderapi.model.query.Query;

import java.util.List;

@RestController
@RequestMapping("/api/table-query")
public class TableQueryController {

    @PostMapping("/add-new-query-to-table")
    public ResponseEntity.BodyBuilder addNewQuery(@RequestBody Query query) {
//        service.save(query);
        return ResponseEntity.ok();
    }

    @PutMapping("/modify-query-in-table")
    public ResponseEntity.BodyBuilder modifyQueryInTable(@RequestBody Query query) {
//        service.update(query);
        return ResponseEntity.ok();
    }

    @DeleteMapping("/delete-table-query-by-id/{id}")
    public ResponseEntity.BodyBuilder deleteTableQuery(@PathVariable("id") Integer id) {
//        service.deleteById(Integer id);
        return ResponseEntity.ok();
    }

    @GetMapping("/get-all-queries-by-table-name/{name}")
    public List<Query> getAllQueriesByTableName(@PathVariable("name") String name) {
//        return service.findAllByTableName(name);
        return null;
    }

    @GetMapping("/get-table-query_by-id/{id}")
    public Query getQueryById(@PathVariable("id") Integer id) {
//        return service.findById(id);
        return null;
    }

    @GetMapping("/get-all-table-queries")
    public List<Query> getAllTableQueries() {
//        return tableService.findAll()
//                .stream()
//                .flatMap(Table::getQueries);
        return null;
    }


}
