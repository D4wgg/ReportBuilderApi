package ru.dawgg.reportbuilderapi.controller;

import static org.springframework.http.HttpStatus.CREATED;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dawgg.reportbuilderapi.model.table.Table;

import javax.validation.Valid;
import ru.dawgg.reportbuilderapi.service.TableService;

@RestController
@RequestMapping("/api/table")
@RequiredArgsConstructor
public class TableController {

    private final TableService tableService;

    @PostMapping("/create-table")
    public ResponseEntity<Void> createTable(@RequestBody @Valid Table table) {
        tableService.createTable(table);
        return new ResponseEntity<>(CREATED);
    }

    @GetMapping("/get-table-by-name/{name}")
    public ResponseEntity<Table> getTableByName(@PathVariable String name) {
        return ResponseEntity.ok(tableService.getTableByName(name));
    }

    @DeleteMapping("/drop-table-by-name/{name}")
    public ResponseEntity<Void> dropTableByName(@PathVariable String name) {
        tableService.dropTable(name);
        return new ResponseEntity<>(CREATED);
    }


}
