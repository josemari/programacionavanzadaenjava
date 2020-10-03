package org.jomaveger.structures;

import static org.junit.Assert.*;

import org.jomaveger.lang.dbc.exceptions.ContractViolationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	private IList<Integer> list;
	Integer siete = 7;
	Integer tres = 3;
	Integer cinco = 5;
	Integer nueve = 9;

	@Before
    public void setUp() {
		list = new LinkedList<>();
    }
    
    @After
    public void tearDown() {
        list = null;
    }
    
    @Test
    public void testDefaultConstructorEnsuresListIsEmpty() {
        assertEquals((Integer)0, list.size());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testAddFirstPrecondition() {
        list.addFirst(null);
    }
    
    @Test
    public void testAddFirstPostcondition() {
        list.addFirst(siete);
        list.addFirst(tres);
        list.addFirst(cinco);
        Integer oldSize = list.size();
        
        list.addFirst(nueve);
        assertEquals(list.getFirst(), nueve);
        assertEquals((Integer)(1 + oldSize), list.size());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testAddLastPrecondition() {
        list.addLast(null);
    }
    
    @Test
    public void testAddLastPostcondition() {
        list.addLast(siete);
        list.addLast(tres);
        list.addLast(cinco);
        Integer oldSize = list.size();
        
        list.addLast(nueve);
        assertEquals(list.getLast(), nueve);
        assertEquals((Integer)(1 + oldSize), list.size());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testGetFirstPrecondition() {
        list.getFirst();
    }
    
    @Test
    public void testGetFirstPostcondition() {
    	list.addLast(siete);
        list.addLast(tres);
        list.addLast(cinco);
        Integer oldSize = list.size();
        
        assertEquals(list.get(0), list.getFirst());
        assertEquals((Integer)(oldSize), list.size());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testGetLastPrecondition() {
        list.getLast();
    }
    
    @Test
    public void testGetLastPostcondition() {
    	list.addLast(siete);
        list.addLast(tres);
        list.addLast(cinco);
        Integer oldSize = list.size();
        
        assertEquals(list.get(list.size() - 1), list.getLast());
        assertEquals((Integer)(oldSize), list.size());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testRemoveFirstPrecondition() {
        list.removeFirst();
    }
    
    @Test
    public void testRemoveFirstPostcondition() {
    	list.addLast(siete);
        list.addLast(tres);
        list.addLast(cinco);
        Integer oldSize = list.size();
        
        list.removeFirst();
        assertEquals((Integer)(oldSize - 1), list.size());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testRemoveLastPrecondition() {
        list.removeLast();
    }
    
    @Test
    public void testRemoveLastPostcondition() {
    	list.addLast(siete);
        list.addLast(tres);
        list.addLast(cinco);
        Integer oldSize = list.size();
        
        list.removeLast();
        assertEquals((Integer)(oldSize - 1), list.size());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testContainsPrecondition() {
        list.contains(null);
    }
    
    @Test
    public void testContainsPostcondition() {
    	list.addLast(siete);
        list.addLast(tres);
        list.addLast(cinco);
        list.addLast(siete);
        Integer oldSize = list.size();
        
        assertTrue(list.contains(siete) && list.indexOf(siete) >= 0);
        assertEquals((Integer)(oldSize), list.size());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testRemovePrecondition() {
        IList<String> slist = new LinkedList<>();
        slist.remove((String)null);
    }
    
    @Test
    public void testRemovePostcondition() {
    	IList<String> slist = new LinkedList<>();
    	slist.addLast("Han");
    	slist.addLast("Luke");
    	slist.addLast("Leia");
        Integer oldSize = slist.size();
        
        slist.remove("Luke");
        assertEquals((Integer)(oldSize - 1), slist.size());
    }
    
    @Test
    public void testClearPostcondition() {
    	list.addLast(siete);
        list.addLast(tres);
        list.addLast(cinco);
        list.addLast(siete);
        list.clear();
        
        assertTrue(list.isEmpty());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testGetPrecondition() {
    	list.get(0);
    }
    
    @Test
    public void testGetPostcondition() {
    	list.addLast(siete);
        list.addLast(tres);
        list.addLast(cinco);
        list.addLast(siete);
        Integer oldSize = list.size();
        
        assertTrue(list.get(3) != null);
        assertEquals((Integer)(oldSize), list.size());
        assertEquals(siete, list.get(3));
    }
    
    @Test(expected = ContractViolationException.class)
    public void testSetPrecondition1() {
    	list.set(0, siete);
    }
    
    @Test(expected = ContractViolationException.class)
    public void testSetPrecondition2() {
    	list.set(0, null);
    }
    
    @Test(expected = ContractViolationException.class)
    public void testSetPrecondition3() {
    	list.set(-1, tres);
    }
    
    @Test(expected = ContractViolationException.class)
    public void testSetPrecondition4() {
    	list.addLast(siete);
        list.addLast(tres);
        list.addLast(cinco);
        list.addLast(siete);
    	list.set(4, nueve);
    }
    
    @Test
    public void testSetPostcondition() {
    	list.addLast(siete);
        list.addLast(tres);
        list.addLast(cinco);
        list.addLast(siete);
        Integer oldSize = list.size();
        
        list.set(2, nueve);
        assertEquals(nueve, list.get(2));
        assertEquals((Integer)(oldSize), list.size());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testAddPrecondition1() {
    	list.add(0, siete);
    }
    
    @Test(expected = ContractViolationException.class)
    public void testAddPrecondition2() {
    	list.add(0, null);
    }
    
    @Test(expected = ContractViolationException.class)
    public void testAddPrecondition3() {
    	list.add(-1, tres);
    }
    
    @Test(expected = ContractViolationException.class)
    public void testAddPrecondition4() {
    	list.addLast(siete);
        list.addLast(tres);
        list.addLast(cinco);
        list.addLast(siete);
    	list.add(5, nueve);
    }
    
    @Test
    public void testAddPostcondition() {
    	list.addLast(siete);
        list.addLast(tres);
        list.addLast(cinco);
        list.addLast(siete);
        Integer oldSize = list.size();
        
        list.add(2, nueve);
        assertEquals(nueve, list.get(2));
        assertEquals((Integer)(oldSize + 1), list.size());
        assertTrue(list.contains(nueve));
    }
    
    @Test(expected = ContractViolationException.class)
    public void testRemovePrecondition1() {
    	IList<String> slist = new LinkedList<>();
        slist.remove((Integer)0);
    }
    
    @Test(expected = ContractViolationException.class)
    public void testRemovePrecondition2() {
    	IList<String> slist = new LinkedList<>();
        slist.remove((Integer)(-1));
    }
    
    @Test(expected = ContractViolationException.class)
    public void testRemovePrecondition3() {
    	IList<String> slist = new LinkedList<>();
    	slist.addLast("Han");
    	slist.addLast("Luke");
    	slist.addLast("Leia");
    	slist.remove((Integer)3);
    }
    
    @Test
    public void testRemoveWithIndexPostcondition() {
    	IList<String> slist = new LinkedList<>();
    	slist.addLast("Han");
    	slist.addLast("Luke");
    	slist.addLast("Leia");
        Integer oldSize = slist.size();
        
        slist.remove(1);
        assertEquals((Integer)(oldSize - 1), slist.size());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testIndexOfPrecondition() {
    	list.indexOf(null);
    }
    
    @Test
    public void testIndexOfPostcondition1() {
    	list.addLast(siete);
        list.addLast(tres);
        list.addLast(cinco);
        list.addLast(siete);
        Integer oldSize = list.size();
        
        assertEquals((Integer)(oldSize), list.size());
        assertEquals((Integer)(-1), list.indexOf(nueve));
    }
    
    @Test
    public void testIndexOfPostcondition2() {
    	list.addLast(siete);
        list.addLast(tres);
        list.addLast(cinco);
        list.addLast(siete);
        Integer oldSize = list.size();
        
        assertEquals((Integer)(oldSize), list.size());
        assertEquals((Integer)(0), list.indexOf(siete));
        assertTrue(list.contains(siete));
    }
    
    @Test(expected = ContractViolationException.class)
    public void testLastIndexOfPrecondition() {
    	list.indexOf(null);
    }
    
    @Test
    public void testLastIndexOfPostcondition1() {
    	list.addLast(siete);
        list.addLast(tres);
        list.addLast(cinco);
        list.addLast(siete);
        Integer oldSize = list.size();
        
        assertEquals((Integer)(oldSize), list.size());
        assertEquals((Integer)(-1), list.lastIndexOf(nueve));
    }
    
    @Test
    public void testLastIndexOfPostcondition2() {
    	list.addLast(siete);
        list.addLast(tres);
        list.addLast(cinco);
        list.addLast(siete);
        Integer oldSize = list.size();
        
        assertEquals((Integer)(oldSize), list.size());
        assertEquals((Integer)(3), list.lastIndexOf(siete));
        assertTrue(list.contains(siete));
        assertTrue(list.lastIndexOf(siete) >= list.indexOf(siete));
    }
    
    @Test
    public void testDeepCopyPostcondition() {
    	list.addLast(siete);
        list.addLast(tres);
        list.addLast(cinco);
        list.addLast(siete);
        
        IList<Integer> clone = list.deepCopy();
        
        assertTrue(list.equals(clone));
    }
}
