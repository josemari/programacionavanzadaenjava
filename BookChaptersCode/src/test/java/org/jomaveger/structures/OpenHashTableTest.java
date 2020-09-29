package org.jomaveger.structures;

import com.google.java.contract.PreconditionError;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OpenHashTableTest {

    private ITable<String, Integer> table;

    @Before
    public void setUp() {
        table = new OpenHashTable<>();
    }

    @After
    public void tearDown() {
        table = null;
    }

    @Test
    public void testDefaultConstructorEnsuresTableIsEmpty() {
        assertEquals((Integer)0, table.size());
        assertTrue(table.isEmpty());
    }

    @Test(expected = PreconditionError.class)
    public void testSetPrecondition1() {
        table.set(null, 100);
    }

    @Test(expected = PreconditionError.class)
    public void testSetPrecondition2() {
        table.set("Luke", null);
    }

    @Test
    public void testSetPostcondition() {
        table.set("Luke", 100);
        table.set("Han", 200);
        table.set("Leia", 300);
        Integer oldSize = table.size();
        IList<String> oldKeyList = table.keyList();

        table.set("Han", 400);
        assertTrue(!table.isEmpty());
        assertEquals(oldSize, table.size());
        assertEquals(oldKeyList, table.keyList());

        table.set("Yoda", 500);
        assertTrue(!table.isEmpty());
        assertEquals((Integer) (oldSize + 1), table.size());
        assertEquals((Integer) (oldKeyList.size() + 1), table.keyList().size());
    }

    @Test(expected = PreconditionError.class)
    public void testGetPrecondition() {
        table.get(null);
    }

    @Test
    public void testGetPostcondition() {
        table.set("Luke", 100);
        table.set("Han", 200);
        table.set("Leia", 300);
        Integer oldSize = table.size();
        IList<String> oldKeyList = table.keyList();

        Integer value = table.get("Han");
        assertEquals((Integer) 200, value);
        assertEquals(oldSize, table.size());
        assertEquals(oldKeyList, table.keyList());
        assertTrue(table.contains("Han"));

        Integer val = table.get("Yoda");
        assertTrue(val == null);
        assertEquals(oldSize, table.size());
        assertEquals(oldKeyList, table.keyList());
        assertTrue(!table.contains("Yoda"));
    }

    @Test(expected = PreconditionError.class)
    public void testRemovePrecondition() {
        table.remove(null);
    }

    @Test
    public void testRemovePostcondition() {
        table.set("Luke", 100);
        table.set("Han", 200);
        table.set("Leia", 300);
        Integer oldSize = table.size();
        IList<String> oldKeyList = table.keyList();

        assertTrue(table.contains("Han"));
        table.remove("Han");
        assertEquals((Integer) (oldSize - 1), table.size());
        assertEquals((Integer) (oldKeyList.size() - 1), table.keyList().size());

        oldSize = table.size();
        oldKeyList = table.keyList();
        assertTrue(!table.contains("Yoda"));
        table.remove("Yoda");
        assertEquals(oldSize, table.size());
        assertEquals(oldKeyList, table.keyList());
    }

    @Test
    public void testClearPostcondition() {
        table.set("Luke", 100);
        table.set("Han", 200);
        table.set("Leia", 300);

        table.clear();
        assertTrue(table.isEmpty());
    }

    @Test(expected = PreconditionError.class)
    public void testContainsPrecondition() {
        table.contains(null);
    }

    @Test
    public void testContainsPostcondition() {
        table.set("Luke", 100);
        table.set("Han", 200);
        table.set("Leia", 300);
        Integer oldSize = table.size();
        IList<String> oldKeyList = table.keyList();

        Boolean contains = table.contains("Han");
        assertTrue(contains);
        assertEquals(oldSize, table.size());
        assertEquals(oldKeyList, table.keyList());
    }

    @Test
    public void testDeepCopyPostcondition() {
        table.set("Luke", 100);
        table.set("Han", 200);
        table.set("Leia", 300);

        ITable<String, Integer> clone = table.deepCopy();

        assertTrue(table.equals(clone));
    }

    @Test
    public void testKeyListPostcondition() {
        table.set("Luke", 100);
        table.set("Han", 200);
        table.set("Leia", 300);

        IList<String> keyList = table.keyList();

        assertTrue(keyList != null);
        assertTrue(keyList.size() >= 0);
        assertTrue(keyList.size() == 3);
    }
}