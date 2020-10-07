package org.jomaveger.examples.chapter6;

import static org.junit.Assert.*;

import org.junit.Test;

public class TripleTest {

	@Test
	public void testTriple() {
		assertEquals((Integer) 6, new Triple().apply(2));
	}

}
