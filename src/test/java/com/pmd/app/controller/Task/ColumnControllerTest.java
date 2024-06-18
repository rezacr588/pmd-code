package com.pmd.app.controller.Task;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.pmd.app.model.TaskModels.Column;
import com.pmd.app.service.TaskServices.ColumnService;

public class ColumnControllerTest {

  @InjectMocks
  ColumnController columnController;

  @Mock
  ColumnService columnService;

  private MockMvc mockMvc;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(columnController).build();
  }

  @Test
  public void testGetAllColumns() throws Exception {
    when(columnService.getAllColumns()).thenReturn(Arrays.asList(new Column(), new Column()));
    mockMvc.perform(get("/columns").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void testGetColumn() throws Exception {
    when(columnService.getColumn(1L)).thenReturn(Optional.of(new Column()));
    mockMvc.perform(get("/columns/{id}", 1L).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void testCreateColumn() throws Exception {
    when(columnService.createColumn(new Column())).thenReturn(new Column());
    mockMvc.perform(post("/columns/")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{}")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void testUpdateColumn() throws Exception {
    when(columnService.updateColumn(new Column())).thenReturn(new Column());
    mockMvc.perform(put("/columns/")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{}")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }
}