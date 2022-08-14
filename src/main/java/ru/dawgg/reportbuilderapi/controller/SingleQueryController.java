package ru.dawgg.reportbuilderapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dawgg.reportbuilderapi.model.query.SingleQuery;
import ru.dawgg.reportbuilderapi.service.SingleQueryService;

import javax.validation.constraints.NotNull;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/single-query")
@RequiredArgsConstructor
public class SingleQueryController {

    private final SingleQueryService queryService;

    @PostMapping("/add-new-query")
    public ResponseEntity<Void> addNewQuery(@RequestBody @NotNull SingleQuery singleQuery) {
        queryService.save(singleQuery);
        return new ResponseEntity<>(CREATED);
    }

    @PutMapping("/modify-query")
    public ResponseEntity<Void> modifyQuery(@RequestBody @NotNull SingleQuery singleQuery) {
        queryService.update(singleQuery);
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/delete-single-query-by-id/{id}")
    public ResponseEntity<Void> deleteSingleQueryById(@PathVariable("id") @NotNull Integer id) {
        queryService.deleteById(id);
        return new ResponseEntity<>(ACCEPTED);
    }

    @GetMapping("/execute-single-query-by-id/{id}")
    public ResponseEntity<Void> executeSingleQueryById(@PathVariable("id") @NotNull Integer id) {
        queryService.executeById(id);
        return new ResponseEntity<>(CREATED);
    }

    @GetMapping("/get-single-query-by-id/{id}")
    public SingleQuery getSingleQueryById(@PathVariable("id") @NotNull Integer id) {
        return queryService.findById(id);
    }

    @GetMapping("/get-all-single-queries")
    public List<SingleQuery> getAllSingleQueries() {
        return queryService.findAll();
    }
}