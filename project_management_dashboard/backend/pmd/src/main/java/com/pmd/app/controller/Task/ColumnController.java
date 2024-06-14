package com.pmd.app.controller.Task;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.pmd.app.model.Column;
import com.pmd.app.service.ColumnService;
import java.util.List;

@RestController
@RequestMapping("/columns")
public class ColumnController {

    private final ColumnService columnService;

    @Autowired
    public ColumnController(ColumnService columnService) {
        this.columnService = columnService;
    }

    @PostMapping
    public Column createColumn(@RequestBody Column column) {
        return columnService.createColumn(column);
    }

    @GetMapping("/{id}")
    public Column getColumn(@PathVariable Long id) {
        return columnService.getColumn(id).orElseThrow(() -> new RuntimeException("Column not found"));
    }

    @GetMapping
    public List<Column> getAllColumns() {
        return columnService.getAllColumns();
    }

    @PutMapping
    public Column updateColumn(@RequestBody Column column) {
        return columnService.updateColumn(column);
    }

    @DeleteMapping("/{id}")
    public void deleteColumn(@PathVariable Long id) {
        columnService.deleteColumn(id);
    }
}