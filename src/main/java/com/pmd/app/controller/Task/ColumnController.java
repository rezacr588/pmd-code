package com.pmd.app.controller.Task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmd.app.model.TaskModels.Column;
import com.pmd.app.service.TaskServices.ColumnService;

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