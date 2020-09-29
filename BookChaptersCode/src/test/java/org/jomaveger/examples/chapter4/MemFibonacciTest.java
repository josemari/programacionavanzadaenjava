package org.jomaveger.examples.chapter4;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.jomaveger.examples.chapter4.MemFibonacci;
import org.junit.Test;

public class MemFibonacciTest {

	@Test
	public void testFibonacciMemoizer() {
		assertEquals(BigInteger.valueOf(55), MemFibonacci.fibonacci(10));
	}

}
