package org.jomaveger.examples.chapter6;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class MemFactorialTest {

	@Test
	public void testFactorialMemoizer() {
		assertEquals(BigInteger.valueOf(120), MemFactorial.factorial(5));
	}

}
