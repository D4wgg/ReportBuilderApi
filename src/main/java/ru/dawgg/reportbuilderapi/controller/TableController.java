package ru.dawgg.reportbuilderapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dawgg.reportbuilderapi.model.table.Table;

@RestController
@RequestMapping("api/table")
public class TableController {

    @PostMapping("/create-table")
    public ResponseEntity.BodyBuilder createTable(@RequestBody Table table) {
//        service.save(table);
        return ResponseEntity.ok();
    }

    @GetMapping("/get-table-by-name/{name}")
    public Table getTableByName(@PathVariable("name") String name) {
//        return service.findTableByName(String name);
        return null;
    }

    @DeleteMapping("/drop-table-by-name/{name}")
    public ResponseEntity.BodyBuilder dropTableByName(@PathVariable("name") String name) {
//        service.deleteByName(String name);
        return ResponseEntity.ok();
    }


}
