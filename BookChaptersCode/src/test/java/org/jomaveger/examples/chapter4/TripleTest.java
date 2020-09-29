package org.jomaveger.examples.chapter4;

import static org.junit.Assert.*;

import org.jomaveger.examples.chapter4.Triple;
import org.junit.Test;

public class TripleTest {

	@Test
	public void testTriple() {
		assertEquals((Integer) 6, new Triple().apply(2));
	}

}
