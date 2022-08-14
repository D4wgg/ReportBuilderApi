package ru.dawgg.reportbuilderapi.controller;

import static org.springframework.http.HttpStatus.CREATED;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dawgg.reportbuilderapi.model.table.Table;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import ru.dawgg.reportbuilderapi.service.TableService;

@RestController
@RequestMapping("/api/table")
@RequiredArgsConstructor
public class TableController {

    private final TableService tableService;

    @PostMapping("/create-table")
    public ResponseEntity<Void> createTable(@RequestBody @Valid Table table) {
        tableService.create(table);
        return new ResponseEntity<>(CREATED);
    }

    @GetMapping("/get-table-by-name/{name}")
    public ResponseEntity<Table> getTableByName(@PathVariable @Size(max = 50) String name) {
        return ResponseEntity.ok(tableService.getByName(name));
    }

    @DeleteMapping("/drop-table-by-name/{name}")
    public ResponseEntity<Void> dropTableByName(@PathVariable @Size(max = 50) String name) {
        tableService.removeByName(name);
        return new ResponseEntity<>(CREATED);
    }


}
