package com.pmd.app.service.TaskServices;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.pmd.app.model.Column;
import com.pmd.app.repository.ColumnRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ColumnService {

    private final ColumnRepository columnRepository;

    @Autowired
    public ColumnService(ColumnRepository columnRepository) {
        this.columnRepository = columnRepository;
    }

    public Column createColumn(Column column) {
        return columnRepository.save(column);
    }

    public Optional<Column> getColumn(Long id) {
        return columnRepository.findById(id);
    }

    public List<Column> getAllColumns() {
        return columnRepository.findAll();
    }

    public Column updateColumn(Column column) {
        return columnRepository.save(column);
    }

    public void deleteColumn(Long id) {
        columnRepository.deleteById(id);
    }
}