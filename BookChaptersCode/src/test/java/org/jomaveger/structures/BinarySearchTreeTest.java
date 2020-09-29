package org.jomaveger.structures;

import com.google.java.contract.PreconditionError;
import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

    private IBinarySearchTree<String, Integer> tree;

    @Before
    public void setUp() {
        tree = new BinarySearchTree<>();
    }

    @After
    public void tearDown() {
        tree = null;
    }

    @Test
    public void testDefaultConstructorEnsuresTreeIsEmpty() {
        assertTrue(tree.isEmpty());
    }

    @Test(expected = PreconditionError.class)
    public void testConstructorPrecondition() {
        tree = new BinarySearchTree<>(null);
    }

    @Test
    public void testConstructorPostcondition() {
        Comparator<String> ordering = (String o1, String o2) -> o1.compareTo(o2);
        tree = new BinarySearchTree<>(ordering);
        assertTrue(tree.isEmpty());
    }

    @Test(expected = PreconditionError.class)
    public void testPutPrecondition1() {
        tree.put(null, 100);
    }

    @Test(expected = PreconditionError.class)
    public void testPutPrecondition2() {
        tree.put("Luke", null);
    }

    @Test(expected = PreconditionError.class)
    public void testPutPrecondition3() {
        tree.put(null, null);
    }

    @Test
    public void testPutPostcondition() {
        tree = makeTree();

        assertEquals("Han", tree.min());
        assertEquals("Yoda", tree.max());
        assertTrue(7 == tree.size());
    }

    @Test(expected = PreconditionError.class)
    public void testGetPrecondition() {
        tree.get(null);
    }

    @Test
    public void testGetPostcondition() {
        tree = makeTree();

        Integer luke = tree.get("Luke");
        assertTrue(luke == 400);

        Integer palpatine = tree.get("Windu");
        assertTrue(palpatine == null);
    }

    @Test(expected = PreconditionError.class)
    public void testContainsPrecondition() {
        tree.contains(null);
    }

    @Test
    public void testContainsPostcondition() {
        tree = makeTree();

        Boolean isLuke = tree.contains("Luke");
        assertTrue(isLuke);

        Boolean isPalpatine = tree.contains("Windu");
        assertTrue(!isPalpatine);
    }

    @Test(expected = PreconditionError.class)
    public void testRemovePrecondition() {
        tree.remove(null);
    }

    @Test
    public void testRemovePostcondition() {
        tree = makeTree();

        assertEquals("Han", tree.min());
        assertEquals("Yoda", tree.max());
        assertTrue(7 == tree.size());

        tree.remove("Palpatine");
        tree.remove("Maul");

        assertEquals("Han", tree.min());
        assertEquals("Yoda", tree.max());
        assertTrue(5 == tree.size());
    }

    @Test(expected = PreconditionError.class)
    public void testMinPrecondition() {
        tree.min();
    }

    @Test(expected = PreconditionError.class)
    public void testMaxPrecondition() {
        tree.max();
    }

    @Test
    public void testMinMaxPostcondition() {
        tree = makeTree();

        assertEquals("Han", tree.min());
        assertEquals("Yoda", tree.max());
        assertTrue(7 == tree.size());
    }

    @Test
    public void testIsEmptyPostcondition() {
        tree = makeTree();
        assertTrue(!tree.isEmpty());
    }

    @Test
    public void testMakeEmptyPostcondition() {
        tree = makeTree();
        assertTrue(!tree.isEmpty());
        tree.makeEmpty();
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testIsBalancedTrue() {
        tree = makeTree();
        Boolean isBalanced = tree.isBalanced();
        assertTrue(!isBalanced);
    }

    @Test
    public void testHeightPostcondition() {
        tree = makeTree();
        Integer height = tree.height();
        assertTrue(height >= 0);
        assertEquals((Integer)6, height);
    }

    @Test
    public void testSizePostcondition() {
        tree = makeTree();
        Integer size = tree.size();
        assertTrue(size >= 0);
        assertEquals((Integer)7, size);
    }

    @Test
    public void testLeavesPostcondition() {
        tree = makeTree();
        Integer leaves = tree.leaves();
        assertTrue(leaves >= 0);
        assertEquals((Integer)2, leaves);
    }

    @Test
    public void testPreOrderRecPostcondition() {
        tree = makeTree();
        IList<TableEntry<String, Integer>> list = tree.preorder();
        assertTrue(list.size() >= 0);
        String result =
            list.toString().replaceFirst("org.jomaveger.structures.LinkedList", "");
        result = result.replaceAll("org.jomaveger.structures.TableEntry", "");

        assertEquals("[[Han, 100], [Leia, 200], [Maul, 300], [Luke, 400], "
                + "[Yoda, 500], [Palpatine, 600], [Vader, 700], ]", result);
    }

    @Test
    public void testInOrderRecPostcondition() {
        tree = makeTree();
        IList<TableEntry<String, Integer>> list = tree.inorder();
        assertTrue(list.size() >= 0);
        String result =
            list.toString().replaceFirst("org.jomaveger.structures.LinkedList", "");
        result = result.replaceAll("org.jomaveger.structures.TableEntry", "");

        assertEquals("[[Han, 100], [Leia, 200], [Luke, 400], [Maul, 300], "
                + "[Palpatine, 600], [Vader, 700], [Yoda, 500], ]", result);
    }

    @Test
    public void testPostOrderRecPostcondition() {
        tree = makeTree();
        IList<TableEntry<String, Integer>> list = tree.postorder();
        assertTrue(list.size() >= 0);
        String result =
            list.toString().replaceFirst("org.jomaveger.structures.LinkedList", "");
        result = result.replaceAll("org.jomaveger.structures.TableEntry", "");

        assertEquals("[[Luke, 400], [Vader, 700], [Palpatine, 600], [Yoda, 500],"
                + " [Maul, 300], [Leia, 200], [Han, 100], ]", result);
    }

    @Test
    public void testLevelOrderPostcondition() {
        tree = makeTree();
        IList<TableEntry<String, Integer>> list = tree.levelorder();
        assertTrue(list.size() >= 0);
        String result =
            list.toString().replaceFirst("org.jomaveger.structures.LinkedList", "");
        result = result.replaceAll("org.jomaveger.structures.TableEntry", "");

        assertEquals("[[Han, 100], [Leia, 200], [Maul, 300], [Luke, 400], "
                + "[Yoda, 500], [Palpatine, 600], [Vader, 700], ]", result);
    }

    @Test
    public void testDeepCopyPostcondition() {
        assertTrue(tree.isEmpty());
        IBinarySearchTree<String, Integer> clone = tree.deepCopy();
        assertTrue(clone.isEmpty());

        IBinarySearchTree<String, Integer> tree2 = makeTree();
        IBinarySearchTree<String, Integer> clone2 = tree2.deepCopy();
        assertTrue(tree2.equals(clone2));
    }

    @Test(expected = PreconditionError.class)
    public void testSortPrecondition() {
        BinarySearchTree btree = new BinarySearchTree();
        btree.sort(null);
    }

    @Test
    public void testSortPostcondition() {
        BinarySearchTree btree = new BinarySearchTree();
        IList<Integer> list = new LinkedList<>();
        list.addLast(7);
        list.addLast(3);
        list.addLast(5);
        list.addLast(9);

        IList<Integer> sortedList = btree.sort(list);

        assertTrue(!sortedList.equals(list));
        assertTrue(sortedList.get(0) == 3);
        assertTrue(sortedList.get(1) == 5);
        assertTrue(sortedList.get(2) == 7);
        assertTrue(sortedList.get(3) == 9);
    }

    private IBinarySearchTree<String, Integer> makeTree() {
       IBinarySearchTree<String, Integer> tree = new BinarySearchTree<>();

        tree.put("Han", 100);
        tree.put("Leia", 200);
        tree.put("Maul", 300);
        tree.put("Luke", 400);

        tree.put("Yoda", 500);
        tree.put("Palpatine", 600);
        tree.put("Vader", 700);

        return tree;
    }
}