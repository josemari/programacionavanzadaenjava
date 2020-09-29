package org.jomaveger.structures;

import com.google.java.contract.PreconditionError;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArrayTest {

    private Array<Integer> array;
    Integer siete = 7;
    Integer tres = 3;
    Integer cinco = 5;
    Integer nueve = 9;

    @Test(expected = PreconditionError.class)
    public void testDefaultConstructorPreconditon() {
        array = new Array<>(-1);
    }

    @Test
    public void testDefaultConstructorPostcondition() {
        array = new Array<>(5);

        assertEquals((Integer)5, array.length());
        assertTrue(array.isEmpty());
    }

    @Test(expected = PreconditionError.class)
    public void testGetPreconditon1() {
        array = new Array<>(5);
        array.get(-2);
    }

    @Test(expected = PreconditionError.class)
    public void testGetPreconditon2() {
        array = new Array<>(5);
        array.get(array.length());
    }

    public void testGetPostcondition() {
        array = new Array<>(5);
        array.set(0, tres);
        Integer i = array.get(0);

        assertEquals(i, tres);
        assertEquals((Integer)5, array.length());
    }

    @Test(expected = PreconditionError.class)
    public void testSetPreconditon1() {
        array = new Array<>(5);
        array.set(siete, -2);
    }

    @Test(expected = PreconditionError.class)
    public void testSetPreconditon2() {
        array = new Array<>(5);
        array.set(siete, array.length());
    }

    @Test(expected = PreconditionError.class)
    public void testSetPreconditon3() {
        array = new Array<>(5);
        array.set(null, array.length());
    }

    public void testSetPostcondition() {
        array = new Array<>(5);
        array.set(tres, 0);
        Integer i = array.get(0);

        assertEquals(i, tres);
        assertEquals((Integer)5, array.length());
        assertTrue(!array.isEmpty());
    }

    @Test
    public void testDeepCopyPostcondition() {
        array = new Array<>(5);
        array.set(siete, 0);
        array.set(tres, 1);
        array.set(cinco, 2);
        array.set(nueve, 3);
        array.set(siete, 4);

        Array<Integer> clone = array.deepCopy();

        assertTrue(array.equals(clone));
    }
}