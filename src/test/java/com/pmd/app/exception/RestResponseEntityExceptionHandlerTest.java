package com.pmd.app.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

public class RestResponseEntityExceptionHandlerTest {

  @Test
  public void testHandleConflict() {
    RestResponseEntityExceptionHandler handler = new RestResponseEntityExceptionHandler();
    UsernameNotFoundException ex = new UsernameNotFoundException("This username does not exist");
    WebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    ResponseEntity<Object> response = handler.handleConflict(ex, request);

    assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    assertEquals("This username does not exist", response.getBody());
  }
}