package org.jomaveger.examples.chapter4;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTest {

	@Test
	public void testBin() {
		assertEquals(1010, Binary.binary(10));
	}

	@Test
	public void testItBin() {
		assertEquals(1010, Binary.itBinary(10));
	}
}
