package org.jomaveger.structures;

import static org.junit.Assert.*;

import org.jomaveger.lang.dbc.exceptions.ContractViolationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedQueueTest {

	private IQueue<Integer> q;

	@Before
    public void setUp() {
		q = new LinkedQueue<>();
    }
    
    @After
    public void tearDown() {
        q = null;
    }
    
    @Test
    public void testDefaultConstructorEnsuresQueueIsEmpty() {
        assertEquals((Integer)0, q.size());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testEnqueuePrecondition() {
        q.enqueue(null);
    }
    
    @Test
    public void testEnqueuePostcondition1() {
    	Integer siete = 7;
        q.enqueue(siete);
        
        assertEquals(siete, q.front());
    }
    
    @Test
    public void testEnqueuePostcondition2() {
    	Integer siete = 7;
    	Integer tres = 3;
    	Integer cinco = 5;
    	q.enqueue(siete);
    	q.enqueue(tres);
    	q.enqueue(cinco);
    	
    	Integer oldSize = q.size();
    	
    	Integer nueve = 9;
    	q.enqueue(nueve);
    	
    	assertEquals((Integer)(1 + oldSize), q.size());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testDequeuePrecondition() {
        q.dequeue();
    }

    @Test
    public void testDequeuePostcondition() {
    	Integer siete = 7;
    	Integer tres = 3;
    	Integer cinco = 5;
        q.enqueue(siete);
        q.enqueue(tres);
        q.enqueue(cinco);
        Integer oldSize = q.size();
        q.dequeue();
        
        assertEquals((Integer)(oldSize - 1), q.size());
    }
    
    @Test(expected = ContractViolationException.class)
    public void testFrontPrecondition() {
        q.front();
    }
    
    @Test
    public void testFrontPostcondition() {
    	Integer siete = 7;
    	Integer tres = 3;
    	Integer cinco = 5;
        q.enqueue(siete);
        q.enqueue(tres);
        q.enqueue(cinco);
        Integer oldSize = q.size();
        Integer peek = q.front();
        
        assertEquals(siete, peek);
        assertEquals((Integer)(oldSize), q.size());
    }
    
    @Test
    public void testSizePostcondition() {
    	Integer siete = 7;
    	Integer tres = 3;
    	Integer cinco = 5;
    	
    	assertTrue(q.size() >= 0);
    	
        q.enqueue(siete);
        q.enqueue(tres);
        q.enqueue(cinco);
        
        assertTrue(q.size() >= 0);
       
        q.dequeue();
        q.dequeue();
        
        assertTrue(q.size() >= 0);
        
        Integer nueve = 9;
        q.enqueue(nueve);
        q.dequeue();
        q.dequeue();
        assertTrue(q.size() >= 0);
    }
    
    @Test
    public void testDeepCopyPostcondition() {
    	Integer siete = 7;
    	Integer tres = 3;
    	Integer cinco = 5;
        q.enqueue(siete);
        q.enqueue(tres);
        q.enqueue(cinco);
        
        IQueue<Integer> clone = q.deepCopy();
        
        assertTrue(q.equals(clone));
    }
}
