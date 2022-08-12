package ru.dawgg.reportbuilderapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dawgg.reportbuilderapi.dto.QueryDto;

import java.util.List;

@RestController
@RequestMapping("/api/single-query")
public class SingleQueryController {

    @PostMapping("/add-new-query")
    public ResponseEntity.BodyBuilder addNewQuery(@RequestBody QueryDto queryDto) {
//        service.save(queryDto);
        return ResponseEntity.ok();
    }

    @PutMapping("/modify-query")
    public ResponseEntity.BodyBuilder modifyQuery(@RequestBody QueryDto queryDto) {
//        service.update(queryDto);
        return ResponseEntity.ok();
    }

    @DeleteMapping("/delete-single-query-by-id/{id}")
    public ResponseEntity.BodyBuilder deleteSingleQueryById(@PathVariable("id") Integer id) {
//        service.deleteById(id);
        return ResponseEntity.ok();
    }

    @GetMapping("/execute-single-query-by-id/{id}")
    public ResponseEntity.BodyBuilder executeSingleQueryById(@PathVariable("id") Integer id) {
//        execute(id);
        return ResponseEntity.ok();
    }

    @GetMapping("/get-single-query-by-id/{id}")
    public QueryDto getSingleQueryById(@PathVariable("id") Integer id) {
//        return service.findById(id);
        return null;
    }

    @GetMapping("/get-all-single-queries")
    public List<QueryDto> getAllSingleQueries() {
        return null;
    }


}
