package org.jomaveger.structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jomaveger.lang.dbc.exceptions.ContractViolationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedStackTest {
	
	private IStack<Integer> stack;

	@Before
    public void setUp() {
		stack = new LinkedStack<>();
    }
    
    @After
    public void tearDown() {
        stack = null;
    }
    
    @Test
    public void testDefaultConstructorEnsuresStackIsEmpty() {
        assertEquals((Integer)0, stack.size());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testPushPrecondition() {
        stack.push(null);
    }
    
    @Test
    public void testPushPostcondition1() {
    	Integer siete = 7;
        stack.push(siete);
        
        assertEquals(siete, stack.peek());
    }
    
    @Test
    public void testPushPostcondition2() {
    	Integer siete = 7;
        stack.push(siete);
        
        assertTrue(stack.size() > 0);
    }
    
    @Test
    public void testPushPostcondition3() {
    	Integer oldSize = stack.size();
    	Integer siete = 7;
        stack.push(siete);
        
        assertEquals((Integer)(1 + oldSize), stack.size());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testPopPrecondition() {
        stack.pop();
    }

    @Test
    public void testPopPostcondition() {
    	Integer siete = 7;
    	Integer tres = 3;
    	Integer cinco = 5;
        stack.push(siete);
        stack.push(tres);
        stack.push(cinco);
        Integer oldSize = stack.size();
        stack.pop();
        
        assertEquals((Integer)(oldSize - 1), stack.size());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testPeekPrecondition() {
        stack.peek();
    }
    
    @Test
    public void testPeekPostcondition() {
    	Integer siete = 7;
    	Integer tres = 3;
    	Integer cinco = 5;
        stack.push(siete);
        stack.push(tres);
        stack.push(cinco);
        Integer oldSize = stack.size();
        Integer peek = stack.peek();
        
        assertEquals(cinco, peek);
        assertEquals((Integer)(oldSize), stack.size());
    }
    
    @Test
    public void testDeepCopyPostcondition() {
    	Integer siete = 7;
    	Integer tres = 3;
    	Integer cinco = 5;
        stack.push(siete);
        stack.push(tres);
        stack.push(cinco);
        
        IStack<Integer> clone = stack.deepCopy();
        
        assertTrue(stack.equals(clone));
    }
}
