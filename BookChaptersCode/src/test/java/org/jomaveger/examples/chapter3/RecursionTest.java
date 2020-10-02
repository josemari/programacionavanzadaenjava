package org.jomaveger.examples.chapter3;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.jomaveger.lang.dbc.exceptions.ContractViolationException;
import org.junit.Test;

public class RecursionTest {

	@Test
	public void testFactorialRecursive0() {
		assertEquals(BigInteger.valueOf(1), Recursion.factorialRecursive(0));
	}
	
	@Test(expected = ContractViolationException.class)
	public void testFactorialRecursiveMinus1() {
		assertEquals(1, Recursion.factorialRecursive(-1));
	}

	@Test
	public void testFactorialRecursive5() {
		assertEquals(BigInteger.valueOf(120), Recursion.factorialRecursive(5));
	}
	
	@Test
	public void testGcd() {
		assertEquals(new Integer(6), Recursion.gcd(12, 18));
	}
	
	@Test(expected = ContractViolationException.class)
	public void testGcdNegative() {
		assertEquals(new Integer(1), Recursion.gcd(-1, 3));
	}
	
	@Test
	public void testFibonacci() {
		assertEquals(BigInteger.valueOf(55), Recursion.fibonacci(10));
	}
	
	@Test(expected = ContractViolationException.class)
	public void testFibonacciNegative() {
		assertEquals(new Integer(1), Recursion.fibonacci(-1));
	}
	
	@Test
	public void testBinarySearch1() {
		int[] array = {5, 7, 9, 13, 15};
		SearchResult result = Recursion.binarySearch(array, 5);
		assertEquals(0, result.index);
		assertEquals(true, result.found);
	}
	
	@Test(expected = ContractViolationException.class)
	public void testBinarySearchPreconditionError() {
		int[] array = {5, 7, 25, 13, 15};
		assertEquals(null, Recursion.binarySearch(array, 5));
	}
	
	@Test
	public void testBinarySearch2() {
		int[] array = {5, 7, 9, 13, 15};
		SearchResult result = Recursion.binarySearch(array, 15);
		assertEquals(4, result.index);
		assertEquals(true, result.found);
	}
	
	@Test
	public void testBinarySearch3() {
		int[] array = {5, 7, 9, 13, 15};
		SearchResult result = Recursion.binarySearch(array, 8);
		assertEquals(2, result.index);
		assertEquals(false, result.found);
	}
}
