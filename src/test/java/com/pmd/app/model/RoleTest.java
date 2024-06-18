package com.pmd.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RoleTest {
	@Test
	public void setName() {
		Role r = new Role("abc");
		String name = "abc";
		r.setName(name);
	}

	@Test
	public void getId() {
		Role r = new Role("abc");
		Long id = 123L;
		r.setId(id);
		assertEquals(id, r.getId());
	}

	@Test
	public void setId() {
		Role r = new Role("abc");
		Long id = 123L;
		r.setId(id);
	}
}
