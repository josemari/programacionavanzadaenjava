package org.jomaveger.examples.chapter3;

import static org.junit.Assert.*;

import org.jomaveger.lang.dbc.exceptions.ContractViolationException;
import org.junit.Test;

public class LoopTest {

	@Test
	public void testIsSortedTrue() {
		int[] array = {5, 7, 9, 13, 15};
		assertTrue(Loop.isSorted(array));
	}
	
	@Test
	public void testIsSortedFalse() {
		int[] array = {5, 7, 25, 13, 15};
		assertFalse(Loop.isSorted(array));
	}

	
	@Test(expected = ContractViolationException.class)
	public void testIsSortedPreconditionError() {
		int[] array = null;
		assertTrue(Loop.isSorted(array));
	}
}
