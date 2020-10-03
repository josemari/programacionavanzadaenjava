package org.jomaveger.structures;

import static org.junit.Assert.*;

import org.jomaveger.lang.dbc.exceptions.ContractViolationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SetTest {

	private ISet<Integer> set;
	Integer siete = 7;
	Integer tres = 3;
	Integer cinco = 5;
	Integer nueve = 9;
	Integer uno = 1;
	Integer dos = 2;
	Integer cuatro = 4;
	Integer seis = 6;
	Integer ocho = 8;
	Integer cero = 0;

	@Before
    public void setUp() {
		set = new Set<>();
    }
    
    @After
    public void tearDown() {
        set = null;
    }
    
    @Test
    public void testDefaultConstructorEnsuresSetIsEmpty() {
        assertEquals((Integer)0, set.cardinal());
        assertTrue(set.isEmpty());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testmakeUnitSetPrecondition() {
        set.makeUnitSet(null);
    }
    
    @Test
    public void testmakeUnitSetPostcondition() {
        set.makeUnitSet(siete);
        assertTrue(!set.isEmpty());
        assertEquals((Integer)1, set.cardinal());
        assertTrue(set.contains(siete));
    }
    
    @Test
    public void testClearPostcondition() {
        set.clear();
        assertEquals((Integer)0, set.cardinal());
        assertTrue(set.isEmpty());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testAddPrecondition() {
        set.add(null);
    }
    
    @Test
    public void testAddPostcondition() {
    	set.add(siete);
        set.add(tres);
        set.add(cinco);
        Integer oldCardinal = set.cardinal();
        
        set.add(cinco);
        set.add(nueve);
        assertTrue(!set.isEmpty());
        assertEquals((Integer) (oldCardinal + 1), set.cardinal());
        assertTrue(set.contains(nueve));
    }
    
    @Test(expected = ContractViolationException.class)
    public void testContainsPrecondition() {
        set.contains(null);
    }
    
    @Test
    public void testContainsPostcondition() {
    	set.add(siete);
        set.add(tres);
        set.add(cinco);
        Integer oldCardinal = set.cardinal();
        
        assertTrue(set.contains(siete));
        assertEquals((Integer) (oldCardinal), set.cardinal());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testRemovePrecondition() {
        set.remove(null);
    }
    
    @Test
    public void testRemovePostcondition() {
    	set.add(siete);
        set.add(tres);
        set.add(cinco);
        Integer oldCardinal = set.cardinal();
        
        set.remove(tres);
        assertTrue(!set.contains(tres));
        assertEquals((Integer) (oldCardinal - 1), set.cardinal());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testIsSubsetPrecondition() {
        set.isSubset(null);
    }
    
    @Test
    public void testIsSubsetPostcondition() {
    	set.add(siete);
        set.add(tres);
        set.add(cinco);
        set.add(nueve);
        Integer oldCardinal = set.cardinal();
        
        ISet<Integer> other = new Set<>();
        other.add(siete);
        other.add(tres);
        other.add(cinco);
        other.add(nueve);
        other.add(uno);
        other.add(cuatro);
        other.add(ocho);
        other.add(seis);
        
        assertTrue(set.isSubset(other));
        assertEquals((Integer) (oldCardinal), set.cardinal());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testUnionPrecondition() {
        set.union(null);
    }
    
    @Test
    public void testUnionPostcondition() {
    	set.add(siete);
        set.add(tres);
        set.add(cinco);
        set.add(nueve);
        Integer oldCardinal = set.cardinal();
        
        ISet<Integer> other = new Set<>();
        other.add(siete);
        other.add(tres);
        other.add(cinco);
        other.add(nueve);
        other.add(uno);
        other.add(cuatro);
        other.add(ocho);
        other.add(seis);
        
        set.union(other);
        assertEquals((Integer) (8), set.cardinal());
        assertTrue(set.cardinal() <= oldCardinal + other.cardinal());
        assertTrue(set.contains(tres));
        assertTrue(set.contains(siete));
        assertTrue(set.contains(cinco));
        assertTrue(set.contains(nueve));
        assertTrue(set.contains(uno));
        assertTrue(set.contains(cuatro));
        assertTrue(set.contains(ocho));
        assertTrue(set.contains(seis));
    }
    
    @Test(expected = ContractViolationException.class)
    public void testIntersectionPrecondition() {
        set.intersection(null);
    }
    
    @Test
    public void testIntersectionPostcondition() {
    	set.add(siete);
        set.add(tres);
        set.add(cinco);
        set.add(nueve);
        Integer oldCardinal = set.cardinal();
        
        ISet<Integer> other = new Set<>();
        other.add(siete);
        other.add(tres);
        other.add(cinco);
        other.add(nueve);
        other.add(uno);
        other.add(cuatro);
        other.add(ocho);
        other.add(seis);
        
        set.intersection(other);
        assertEquals((Integer) (4), set.cardinal());
        assertTrue(set.cardinal() <= oldCardinal + other.cardinal());
        assertTrue(set.contains(tres));
        assertTrue(set.contains(siete));
        assertTrue(set.contains(cinco));
        assertTrue(set.contains(nueve));
    }
    
    @Test(expected = ContractViolationException.class)
    public void testDifferencePrecondition() {
        set.difference(null);
    }
    
    @Test
    public void testDifferencePostcondition() {
    	set.add(siete);
        set.add(tres);
        set.add(cinco);
        set.add(nueve);
        set.add(cero);
        Integer oldCardinal = set.cardinal();
        
        ISet<Integer> other = new Set<>();
        other.add(siete);
        other.add(tres);
        other.add(cinco);
        other.add(nueve);
        other.add(uno);
        other.add(cuatro);
        other.add(ocho);
        other.add(seis);
        
        set.difference(other);
        assertEquals((Integer) (1), set.cardinal());
        assertTrue(set.cardinal() <= oldCardinal);
        assertTrue(set.contains(cero));
        assertTrue(!set.contains(siete));
        assertTrue(!set.contains(cinco));
        assertTrue(!set.contains(nueve));
        assertTrue(!set.contains(tres));
    }
    
    @Test
    public void testDeepCopyPostcondition() {
    	set.add(siete);
        set.add(tres);
        set.add(cinco);
        set.add(nueve);
        
        ISet<Integer> clone = set.deepCopy();
        
        assertTrue(set.equals(clone));
    }
}
