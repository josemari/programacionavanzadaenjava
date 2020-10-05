package org.jomaveger.structures;

import org.jomaveger.lang.dbc.exceptions.ContractViolationException;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BagTest {

    private IBag<String> bag;
    String siete = "siete";
    String tres = "tres";
    String cinco = "cinco";
    String nueve = "nueve";
    String uno = "uno";
    String dos = "dos";
    String cuatro = "cuatro";
    String seis = "seis";
    String ocho = "ocho";
    String cero = "cero";

    @Before
    public void setUp() {
        bag = new Bag<>();
    }

    @After
    public void tearDown() {
        bag = null;
    }

    @Test
    public void testDefaultConstructorEnsuresBagIsEmpty() {
        assertEquals((Integer)0, bag.cardinal());
        assertTrue(bag.isEmpty());
        assertEquals((Integer)0, bag.cardinalDistinct());
    }

    @Test
    public void testClearPostcondition() {
        bag.add(cero);
        bag.add(uno);
        bag.add(tres);
        bag.clear();
        assertEquals((Integer)0, bag.cardinal());
        assertTrue(bag.isEmpty());
    }

    @Test(expected = ContractViolationException.class)
    public void testAddPrecondition() {
        bag.add(null);
    }

    @Test
    public void testAddPostcondition() {
        bag.add(siete);
        bag.add(tres);
        bag.add(cinco);
        Integer oldCardinal = bag.cardinal();
        Integer oldMultiplicity = bag.multiplicity(siete);
        Integer oldCardinalDistinct = bag.cardinalDistinct();

        bag.add(siete);
        assertTrue(!bag.isEmpty());
        assertEquals((Integer) (oldCardinal + 1), bag.cardinal());
        assertEquals((Integer) (oldMultiplicity + 1), bag.multiplicity(siete));
        assertEquals((Integer) (oldCardinalDistinct), bag.cardinalDistinct());
    }

    @Test(expected = ContractViolationException.class)
    public void testMultiplicityPrecondition() {
        bag.multiplicity(null);
    }

    @Test
    public void testMultiplicityPostcondition() {
        bag.add(siete);
        bag.add(tres);
        bag.add(cinco);
        bag.add(siete);
        bag.add(siete);
        Integer multiplicity = bag.multiplicity(siete);

        assertTrue(multiplicity >= 0);
        assertTrue(multiplicity == 3);
        assertTrue(multiplicity <= bag.cardinal());
        assertTrue(multiplicity <= bag.cardinalDistinct());
    }

    @Test(expected = ContractViolationException.class)
    public void testDeletePrecondition() {
        bag.delete(null);
    }

    @Test
    public void testDeletePostcondition() {
        bag.add(siete);
        bag.add(tres);
        bag.add(cinco);
        bag.add(siete);
        bag.add(siete);
        Integer oldCardinal = bag.cardinal();
        Integer oldMultiplicity = bag.multiplicity(siete);
        Integer oldCardinalDistinct = bag.cardinalDistinct();

        bag.delete(siete);
        assertTrue(!bag.isEmpty());
        assertEquals((Integer) (oldCardinal - 1), bag.cardinal());
        assertEquals((Integer) (oldMultiplicity - 1), bag.multiplicity(siete));
        assertEquals((Integer) (oldCardinalDistinct), bag.cardinalDistinct());
    }

    @Test(expected = ContractViolationException.class)
    public void testRemovePrecondition() {
        bag.remove(null);
    }

    @Test
    public void testRemovePostcondition() {
        bag.add(siete);
        bag.add(tres);
        bag.add(cinco);
        bag.add(siete);
        bag.add(siete);
        Integer oldCardinal = bag.cardinal();
        Integer oldMultiplicity = bag.multiplicity(siete);
        Integer oldCardinalDistinct = bag.cardinalDistinct();

        bag.remove(siete);
        assertTrue(!bag.isEmpty());
        assertEquals((Integer) (oldCardinal - oldMultiplicity), bag.cardinal());
        assertEquals((Integer) 0, bag.multiplicity(siete));
        assertEquals((Integer) (oldCardinalDistinct - 1), bag.cardinalDistinct());
    }

    @Test(expected = ContractViolationException.class)
    public void testUnionPrecondition() {
        bag.union(null);
    }

    @Test
    public void testUnionPostcondition() {
        bag.add(siete);
        bag.add(tres);
        bag.add(cinco);
        bag.add(siete);
        Integer oldCardinal = bag.cardinal();
        Integer oldCardinalDistinct = bag.cardinalDistinct();

        IBag<String> other = new Bag<>();
        other.add(siete);
        other.add(tres);
        other.add(cinco);
        other.add(nueve);
        other.add(cinco);
        other.add(siete);
        other.add(ocho);
        other.add(cinco);

        bag.union(other);
        assertTrue(bag.cardinal() == oldCardinal + other.cardinal());
        assertTrue(bag.cardinalDistinct() <= oldCardinalDistinct + other.cardinalDistinct());
    }

    @Test(expected = ContractViolationException.class)
    public void testIntersectionPrecondition() {
        bag.union(null);
    }

    @Test
    public void testIntersectionPostcondition() {
        bag.add(siete);
        bag.add(tres);
        bag.add(cinco);
        bag.add(siete);
        Integer oldCardinal = bag.cardinal();
        Integer oldCardinalDistinct = bag.cardinalDistinct();

        IBag<String> other = new Bag<>();
        other.add(siete);
        other.add(tres);
        other.add(cinco);
        other.add(nueve);
        other.add(cinco);
        other.add(siete);
        other.add(ocho);
        other.add(cinco);

        bag.intersection(other);
        assertTrue(bag.cardinal() < oldCardinal + other.cardinal());
        assertTrue(bag.cardinalDistinct() < oldCardinalDistinct + other.cardinalDistinct());
    }

    @Test(expected = ContractViolationException.class)
    public void testDifferencePrecondition() {
        bag.union(null);
    }

    @Test
    public void testDifferencePostcondition() {
        bag.add(siete);
        bag.add(tres);
        bag.add(cinco);
        bag.add(siete);
        Integer oldCardinal = bag.cardinal();
        Integer oldCardinalDistinct = bag.cardinalDistinct();

        IBag<String> other = new Bag<>();
        other.add(siete);
        other.add(tres);
        other.add(cinco);
        other.add(nueve);
        other.add(cinco);
        other.add(siete);
        other.add(ocho);
        other.add(cinco);

        bag.difference(other);
        assertTrue(bag.cardinal() <= oldCardinal + other.cardinal());
        assertTrue(bag.cardinalDistinct() <= oldCardinalDistinct + other.cardinalDistinct());
    }

    @Test
    public void testDeepCopyPostcondition() {
        bag.add(siete);
        bag.add(tres);
        bag.add(cinco);
        bag.add(nueve);
        bag.add(siete);
        bag.add(siete);

        IBag<String> clone = bag.deepCopy();

        assertTrue(bag.equals(clone));
    }
}