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
	
	@Test
	public void testBinarySearch1() {
		int[] array = {5, 7, 9, 13, 15};
		assertEquals(0, Loop.binarySearch(array, 5));
	}
	
	@Test(expected = ContractViolationException.class)
	public void testBinarySearchPreconditionError() {
		int[] array = {5, 7, 25, 13, 15};
		assertEquals(0, Loop.binarySearch(array, 5));
	}
	
	@Test
	public void testBinarySearch2() {
		int[] array = {5, 7, 9, 13, 15};
		assertEquals(4, Loop.binarySearch(array, 15));
	}
	
	@Test
	public void testBinarySearch3() {
		int[] array = {5, 7, 9, 13, 15};
		assertEquals(1, Loop.binarySearch(array, 8));
	}
}
