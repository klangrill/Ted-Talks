package edu.ycp.cs320.rvandemark.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.rvandemark.model.Assignment;

public class AssignmentTest {
	private Assignment model;
	
	@Before
	public void setUp() {
		model = new Assignment();
		model.setAssign("Watch Video");
		model.setDate("05/10");
	}
	
	//test both set and get method
	@Test
	public void testGetAssign() {
		model.setAssign("Watch Video");
		assertEquals("Watch Video", model.getAssign());
		assertNotEquals("Watch video 9", model.getAssign());
	}
	
	//test both set and get method
	@Test
	public void testGetDate() {
		model.setDate("05/10");
		assertEquals("05/10", model.getDate());
		assertNotEquals("05/ 10", model.getDate());
	}
}