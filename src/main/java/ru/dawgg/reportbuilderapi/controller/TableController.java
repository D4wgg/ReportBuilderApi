package ru.dawgg.reportbuilderapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dawgg.reportbuilderapi.model.table.Table;
import ru.dawgg.reportbuilderapi.model.tablequery.Query;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/table")
public class TableController {

    @PostMapping("/create-table")
    public Table createTable(@RequestBody @Valid Table table) {
//        service.save(table);
        return table;
    }

    @PostMapping("/test")
    public String returnStr(@RequestBody String str) {
        return str;
    }

    @GetMapping("/get-table-by-name/{name}")
    public Table getTableByName(@PathVariable String name) {
//        return service.findTableByName(String name);
        return Table.builder().tableName(name).build();
    }

    @DeleteMapping("/drop-table-by-name/{name}")
    public ResponseEntity.BodyBuilder dropTableByName(@PathVariable String name) {
//        service.deleteByName(String name);
        return ResponseEntity.ok();
    }


}
