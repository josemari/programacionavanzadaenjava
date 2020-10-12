package org.jomaveger.structures;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GraphAlgorithmsTest {
	
	private GraphAlgorithms<Integer> g1;
	private Vertex<Integer> a = new Vertex<>("A", 10);
	private Vertex<Integer> b = new Vertex<>("B", 20);
	private Vertex<Integer> c = new Vertex<>("C", 30);
	private Vertex<Integer> d = new Vertex<>("D", 40);
	private Vertex<Integer> e = new Vertex<>("E", 50);
	private Vertex<Integer> f = new Vertex<>("F", 60);
	private Vertex<Integer> g = new Vertex<>("G", 70);
	private Edge<Integer> ab = new Edge<>(a, b);
	private Edge<Integer> ad = new Edge<>(a, d);
	private Edge<Integer> bc = new Edge<>(b, c);
	private Edge<Integer> be = new Edge<>(b, e); 
	private Edge<Integer> dc = new Edge<>(d, c);
	private Edge<Integer> ed = new Edge<>(e, d);
	private Edge<Integer> fb = new Edge<>(f, b);
	private Edge<Integer> fg = new Edge<>(f, g);
	
	@Before
    public void setUp() {
		g1 = new GraphAlgorithms<>(true, false);
    }
    
    @After
    public void tearDown() {
        g1 = null;
    }

	@Test
	public void testDFS() {
		g1.addVertex(a);
        g1.addVertex(b);
        g1.addVertex(c);
        g1.addVertex(d);
        g1.addVertex(e);
        g1.addVertex(f);
        g1.addVertex(g);
        g1.addEdge(ab);
        g1.addEdge(ad);
        g1.addEdge(bc);
        g1.addEdge(be);
        g1.addEdge(dc);
        g1.addEdge(ed);
        g1.addEdge(fb);
        g1.addEdge(fg);
        ITable<Vertex<Integer>, Integer> path = new LinkedTable<>();
        path.set(a, 0);
        path.set(b, 0);
        path.set(c, 0);
        path.set(d, 0);
        path.set(e, 0);
        path.set(f, 0);
        path.set(g, 0);
        IList<Vertex<Integer>> dfsList = new LinkedList<>();
        dfsList = g1.DFS(a, 0, path, dfsList);
        assertTrue(dfsList.contains(a));
        assertTrue(dfsList.contains(b));
        assertTrue(dfsList.contains(c));
        assertTrue(dfsList.contains(d));
        assertTrue(dfsList.contains(e));
        assertFalse(dfsList.contains(f));
        assertFalse(dfsList.contains(g));
	}
	
	@Test
	public void testAllDFS() {
		g1.addVertex(a);
        g1.addVertex(b);
        g1.addVertex(c);
        g1.addVertex(d);
        g1.addVertex(e);
        g1.addVertex(f);
        g1.addVertex(g);
        g1.addEdge(ab);
        g1.addEdge(ad);
        g1.addEdge(bc);
        g1.addEdge(be);
        g1.addEdge(dc);
        g1.addEdge(ed);
        g1.addEdge(fb);
        g1.addEdge(fg);
        IList<Vertex<Integer>> dfsList = g1.allDFS();
        String result =
                dfsList.toString().replaceFirst("org.jomaveger.structures.LinkedList", "");
        assertEquals("[(A,10), (B,20), (C,30), (E,50), (D,40), (F,60), (G,70), ]", result);
        assertTrue(dfsList.contains(a));
        assertTrue(dfsList.contains(b));
        assertTrue(dfsList.contains(c));
        assertTrue(dfsList.contains(d));
        assertTrue(dfsList.contains(e));
        assertTrue(dfsList.contains(f));
        assertTrue(dfsList.contains(g));
	}
	
	@Test
	public void testitDFS() {
		g1.addVertex(a);
        g1.addVertex(b);
        g1.addVertex(c);
        g1.addVertex(d);
        g1.addVertex(e);
        g1.addVertex(f);
        g1.addVertex(g);
        g1.addEdge(ab);
        g1.addEdge(ad);
        g1.addEdge(bc);
        g1.addEdge(be);
        g1.addEdge(dc);
        g1.addEdge(ed);
        g1.addEdge(fb);
        g1.addEdge(fg);
        ITable<Vertex<Integer>, Integer> path = new LinkedTable<>();
        path.set(a, 0);
        path.set(b, 0);
        path.set(c, 0);
        path.set(d, 0);
        path.set(e, 0);
        path.set(f, 0);
        path.set(g, 0);
        IList<Vertex<Integer>> dfsList = new LinkedList<>();
        dfsList = g1.itDFS(a, path, dfsList);
        assertTrue(dfsList.contains(a));
        assertTrue(dfsList.contains(b));
        assertTrue(dfsList.contains(c));
        assertTrue(dfsList.contains(d));
        assertTrue(dfsList.contains(e));
        assertFalse(dfsList.contains(f));
        assertFalse(dfsList.contains(g));
	}
	
	@Test
	public void testAllItDFS() {
		g1.addVertex(a);
        g1.addVertex(b);
        g1.addVertex(c);
        g1.addVertex(d);
        g1.addVertex(e);
        g1.addVertex(f);
        g1.addVertex(g);
        g1.addEdge(ab);
        g1.addEdge(ad);
        g1.addEdge(bc);
        g1.addEdge(be);
        g1.addEdge(dc);
        g1.addEdge(ed);
        g1.addEdge(fb);
        g1.addEdge(fg);
        IList<Vertex<Integer>> dfsList = g1.allItDFS();
        String result =
                dfsList.toString().replaceFirst("org.jomaveger.structures.LinkedList", "");
        assertEquals("[(A,10), (B,20), (C,30), (E,50), (D,40), (F,60), (G,70), ]", result);
        assertTrue(dfsList.contains(a));
        assertTrue(dfsList.contains(b));
        assertTrue(dfsList.contains(c));
        assertTrue(dfsList.contains(d));
        assertTrue(dfsList.contains(e));
        assertTrue(dfsList.contains(f));
        assertTrue(dfsList.contains(g));
	}
	
	@Test
	public void testBFS() {
		g1.addVertex(a);
        g1.addVertex(b);
        g1.addVertex(c);
        g1.addVertex(d);
        g1.addVertex(e);
        g1.addVertex(f);
        g1.addVertex(g);
        g1.addEdge(ab);
        g1.addEdge(ad);
        g1.addEdge(bc);
        g1.addEdge(be);
        g1.addEdge(dc);
        g1.addEdge(ed);
        g1.addEdge(fb);
        g1.addEdge(fg);
        ITable<Vertex<Integer>, Integer> path = new LinkedTable<>();
        path.set(a, 0);
        path.set(b, 0);
        path.set(c, 0);
        path.set(d, 0);
        path.set(e, 0);
        path.set(f, 0);
        path.set(g, 0);
        IList<Vertex<Integer>> bfsList = new LinkedList<>();
        bfsList = g1.BFS(a, path, bfsList);
        assertTrue(bfsList.contains(a));
        assertTrue(bfsList.contains(b));
        assertTrue(bfsList.contains(c));
        assertTrue(bfsList.contains(d));
        assertTrue(bfsList.contains(e));
        assertFalse(bfsList.contains(f));
        assertFalse(bfsList.contains(g));
	}
	
	@Test
	public void testAllBFS() {
		g1.addVertex(a);
        g1.addVertex(b);
        g1.addVertex(c);
        g1.addVertex(d);
        g1.addVertex(e);
        g1.addVertex(f);
        g1.addVertex(g);
        g1.addEdge(ab);
        g1.addEdge(ad);
        g1.addEdge(bc);
        g1.addEdge(be);
        g1.addEdge(dc);
        g1.addEdge(ed);
        g1.addEdge(fb);
        g1.addEdge(fg);
        IList<Vertex<Integer>> bfsList = g1.allBFS();
        String result =
        		bfsList.toString().replaceFirst("org.jomaveger.structures.LinkedList", "");
        assertEquals("[(A,10), (B,20), (D,40), (C,30), (E,50), (F,60), (G,70), ]", result);
        assertTrue(bfsList.contains(a));
        assertTrue(bfsList.contains(b));
        assertTrue(bfsList.contains(c));
        assertTrue(bfsList.contains(d));
        assertTrue(bfsList.contains(e));
        assertTrue(bfsList.contains(f));
        assertTrue(bfsList.contains(g));
	}
}
