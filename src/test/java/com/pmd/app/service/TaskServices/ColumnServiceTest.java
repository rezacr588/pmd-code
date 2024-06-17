package com.pmd.app.service.TaskServices;

import com.pmd.app.model.TaskModels.Column;
import com.pmd.app.repository.TasksRepositories.ColumnRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ColumnServiceTest {

  @InjectMocks
  private ColumnService columnService;

  @Mock
  private ColumnRepository columnRepository;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void createColumnTest() {
    Column column = new Column();
    when(columnRepository.save(column)).thenReturn(column);

    Column createdColumn = columnService.createColumn(column);

    assertEquals(createdColumn, column);
    verify(columnRepository, times(1)).save(column);
  }

  @Test
  public void getColumnTest() {
    Column column = new Column();
    when(columnRepository.findById(1L)).thenReturn(Optional.of(column));

    Optional<Column> returnedColumn = columnService.getColumn(1L);

    assertEquals(returnedColumn.get(), column);
    verify(columnRepository, times(1)).findById(1L);
  }

  @Test
  public void getAllColumnsTest() {
    Column column1 = new Column();
    Column column2 = new Column();
    List<Column> columns = Arrays.asList(column1, column2);

    when(columnRepository.findAll()).thenReturn(columns);

    List<Column> returnedColumns = columnService.getAllColumns();

    assertEquals(returnedColumns, columns);
    verify(columnRepository, times(1)).findAll();
  }

  @Test
  public void updateColumnTest() {
    Column column = new Column();
    when(columnRepository.save(column)).thenReturn(column);

    Column updatedColumn = columnService.updateColumn(column);

    assertEquals(updatedColumn, column);
    verify(columnRepository, times(1)).save(column);
  }

  @Test
  public void deleteColumnTest() {
    doNothing().when(columnRepository).deleteById(1L);

    columnService.deleteColumn(1L);

    verify(columnRepository, times(1)).deleteById(1L);
  }
}