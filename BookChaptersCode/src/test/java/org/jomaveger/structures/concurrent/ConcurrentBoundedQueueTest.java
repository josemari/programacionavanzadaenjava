package org.jomaveger.structures.concurrent;

import org.jomaveger.structures.concurrent.ConcurrentBoundedQueue;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class ConcurrentBoundedQueueTest {
    
    private ConcurrentBoundedQueue<Integer> bq;
    
    @Before
    public void setUp() {
	bq = new ConcurrentBoundedQueue<>(10);
    }
    
    @After
    public void tearDown() {
        bq = null;
    }
    
    @Test
    public void testIsEmptyWhenConstructed() {
        assertTrue(bq.isEmpty());
        assertFalse(bq.isFull());
    }

    @Test
    public void testIsFullAfterEnqueue() {
        for (int i = 0; i < 10; i++) {
            bq.enqueue(i);
        }
        assertTrue(bq.isFull());
        assertFalse(bq.isEmpty());
        assertEquals((Integer)10, bq.size());
        assertEquals((Integer)0, bq.front());
    }
}
