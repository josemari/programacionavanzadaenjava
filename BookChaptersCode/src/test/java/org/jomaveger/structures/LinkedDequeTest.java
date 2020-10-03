package org.jomaveger.structures;

import org.jomaveger.lang.dbc.exceptions.ContractViolationException;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedDequeTest {

    private IDequeue<Integer> d;
    Integer siete = 7;
    Integer tres = 3;
    Integer cinco = 5;
    Integer nueve = 9;

    @Before
    public void setUp() {
        d = new LinkedDequeue<>();
    }

    @After
    public void tearDown() {
        d = null;
    }

    @Test
    public void testDefaultConstructorEnsuresDequeueIsEmpty() {
        assertEquals((Integer)0, d.size());
    }

    @Test(expected = ContractViolationException.class)
    public void testAddFirstPrecondition() {
        d.addFirst(null);
    }

    @Test
    public void testAddFirstPostcondition() {
        d.addFirst(siete);
        d.addFirst(tres);
        d.addFirst(cinco);
        Integer oldSize = d.size();

        d.addFirst(nueve);
        assertEquals(d.getFirst(), nueve);
        assertEquals((Integer)(1 + oldSize), d.size());
    }

    @Test(expected = ContractViolationException.class)
    public void testAddLastPrecondition() {
        d.addLast(null);
    }

    @Test
    public void testAddLastPostcondition() {
        d.addLast(siete);
        d.addLast(tres);
        d.addLast(cinco);
        Integer oldSize = d.size();

        d.addLast(nueve);
        assertEquals(d.getLast(), nueve);
        assertEquals((Integer)(1 + oldSize), d.size());
    }

    @Test(expected = ContractViolationException.class)
    public void testGetFirstPrecondition() {
        d.getFirst();
    }

    @Test
    public void testGetFirstPostcondition() {
        d.addLast(siete);
        d.addLast(tres);
        d.addLast(cinco);
        Integer oldSize = d.size();

        assertEquals((Integer)(oldSize), d.size());
    }

    @Test(expected = ContractViolationException.class)
    public void testGetLastPrecondition() {
        d.getLast();
    }

    @Test
    public void testGetLastPostcondition() {
        d.addLast(siete);
        d.addLast(tres);
        d.addLast(cinco);
        Integer oldSize = d.size();

        assertEquals((Integer)(oldSize), d.size());
    }

    @Test(expected = ContractViolationException.class)
    public void testRemoveFirstPrecondition() {
        d.removeFirst();
    }

    @Test
    public void testRemoveFirstPostcondition() {
        d.addLast(siete);
        d.addLast(tres);
        d.addLast(cinco);
        Integer oldSize = d.size();

        d.removeFirst();
        assertEquals((Integer)(oldSize - 1), d.size());
    }

    @Test(expected = ContractViolationException.class)
    public void testRemoveLastPrecondition() {
        d.removeLast();
    }

    @Test
    public void testRemoveLastPostcondition() {
        d.addLast(siete);
        d.addLast(tres);
        d.addLast(cinco);
        Integer oldSize = d.size();

        d.removeLast();
        assertEquals((Integer)(oldSize - 1), d.size());
    }

    @Test(expected = ContractViolationException.class)
    public void testContainsPrecondition() {
        d.contains(null);
    }

    @Test
    public void testContainsPostcondition() {
        d.addLast(siete);
        d.addLast(tres);
        d.addLast(cinco);
        d.addLast(siete);
        Integer oldSize = d.size();

        assertEquals((Integer)(oldSize), d.size());
    }

    @Test
    public void testDeepCopyPostcondition() {
        d.addLast(siete);
        d.addLast(tres);
        d.addLast(cinco);
        d.addLast(siete);

        IDequeue<Integer> clone = d.deepCopy();

        assertTrue(d.equals(clone));
    }
}