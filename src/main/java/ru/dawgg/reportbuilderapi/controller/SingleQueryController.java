package ru.dawgg.reportbuilderapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dawgg.reportbuilderapi.model.query.SingleQuery;
import ru.dawgg.reportbuilderapi.service.SingleQueryService;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/single-query")
@RequiredArgsConstructor
public class SingleQueryController {

    private final SingleQueryService queryService;

    @PostMapping("/add-new-query")
    public ResponseEntity<Void> addNewQuery(@RequestBody SingleQuery singleQuery) {
        queryService.save(singleQuery);
        return new ResponseEntity<>(CREATED);
    }

    @PutMapping("/modify-query")
    public ResponseEntity<Void> modifyQuery(@RequestBody SingleQuery singleQuery) {
        queryService.update(singleQuery);
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/delete-single-query-by-id/{id}")
    public ResponseEntity<Void> deleteSingleQueryById(@PathVariable("id") Integer id) {
        queryService.deleteById(id);
        return new ResponseEntity<>(ACCEPTED);
    }

    @GetMapping("/execute-single-query-by-id/{id}")
    public ResponseEntity<Void> executeSingleQueryById(@PathVariable("id") Integer id) {
        queryService.executeById(id);
        return new ResponseEntity<>(CREATED);
    }

    @GetMapping("/get-single-query-by-id/{id}")
    public SingleQuery getSingleQueryById(@PathVariable("id") Integer id) {
        return queryService.findById(id);
    }

    @GetMapping("/get-all-single-queries")
    public List<SingleQuery> getAllSingleQueries() {
        return queryService.findAll();
    }


}
