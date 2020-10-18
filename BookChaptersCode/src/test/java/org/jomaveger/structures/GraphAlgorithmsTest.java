package org.jomaveger.structures;

import static org.junit.Assert.*;

import org.jomaveger.structures.GraphAlgorithms.CostPath;
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
	
	private Vertex<Integer> uno = new Vertex<>("1", 10);
	private Vertex<Integer> dos = new Vertex<>("2", 20);
	private Vertex<Integer> tres = new Vertex<>("3", 30);
	private Vertex<Integer> cuatro = new Vertex<>("4", 40);
	private Vertex<Integer> cinco = new Vertex<>("5", 50);
	private Vertex<Integer> seis = new Vertex<>("6", 60);
	private Vertex<Integer> siete = new Vertex<>("7", 70);
	private Vertex<Integer> ocho = new Vertex<>("8", 80);
	private Vertex<Integer> nueve = new Vertex<>("9", 90);
	private Vertex<Integer> diez = new Vertex<>("10", 100);
	private Vertex<Integer> once = new Vertex<>("11", 110);
	private Vertex<Integer> doce = new Vertex<>("12", 120);
	
	private Edge<Integer> ab = new Edge<>(a, b);
	private Edge<Integer> ad = new Edge<>(a, d);
	private Edge<Integer> bc = new Edge<>(b, c);
	private Edge<Integer> be = new Edge<>(b, e); 
	private Edge<Integer> dc = new Edge<>(d, c);
	private Edge<Integer> ed = new Edge<>(e, d);
	private Edge<Integer> fb = new Edge<>(f, b);
	private Edge<Integer> fg = new Edge<>(f, g);
	
	private Edge<Integer> unodos = new Edge<>(uno, dos);
	private Edge<Integer> dostres = new Edge<>(dos, tres);
	private Edge<Integer> doscinco = new Edge<>(dos, cinco);
	private Edge<Integer> unocuatro = new Edge<>(uno, cuatro);
	private Edge<Integer> cuatrocinco = new Edge<>(cuatro, cinco);
	private Edge<Integer> tresdos = new Edge<>(tres, dos);
	private Edge<Integer> unotres = new Edge<>(uno, tres);
	private Edge<Integer> cincouno = new Edge<>(cinco, uno);
	private Edge<Integer> cincotres = new Edge<>(cinco, tres);
	
	private Edge<Integer> unocinco = new Edge<>(uno, cinco);
	private Edge<Integer> unoseis = new Edge<>(uno, seis);
	private Edge<Integer> trescinco = new Edge<>(tres, cinco);
	private Edge<Integer> cincoseis = new Edge<>(cinco, seis);
	private Edge<Integer> cincosiete = new Edge<>(cinco, siete);
	private Edge<Integer> seisocho = new Edge<>(seis, ocho);
	private Edge<Integer> nuevetres = new Edge<>(nueve, tres);
	private Edge<Integer> nuevediez = new Edge<>(nueve, diez);
	private Edge<Integer> nueveonce = new Edge<>(nueve, once);
	private Edge<Integer> diezonce = new Edge<>(diez, once);
	private Edge<Integer> diezdoce = new Edge<>(diez, doce);
	private Edge<Integer> oncedoce = new Edge<>(once, doce);
	
	private Edge<Integer> unodos1 = new Edge<>(uno, dos, 1.0);
	private Edge<Integer> unotres1 = new Edge<>(uno, tres, 1.0);
	private Edge<Integer> unocuatro3 = new Edge<>(uno, cuatro, 3.0);
	private Edge<Integer> dostres1 = new Edge<>(dos, tres, 1.0);
	private Edge<Integer> trescuatro2 = new Edge<>(tres, cuatro, 2.0);
	private Edge<Integer> trescinco4 = new Edge<>(tres, cinco, 4.0);
	private Edge<Integer> cincoseis2 = new Edge<>(cinco, seis, 2.0);
	private Edge<Integer> cincosiete2 = new Edge<>(cinco, siete, 2.0);
	private Edge<Integer> seissiete1 = new Edge<>(seis, siete, 1.0);
	
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
	
	@Test
	public void testIsConnected() {
		GraphAlgorithms<Integer> g2;
		g2 = new GraphAlgorithms<>(false, false);
		g2.addVertex(uno);
        g2.addVertex(dos);
        g2.addVertex(tres);
        g2.addVertex(cuatro);
        g2.addVertex(cinco);
        g2.addEdge(unodos);
        g2.addEdge(dostres);
        g2.addEdge(doscinco);
        g2.addEdge(unocuatro);
        g2.addEdge(cuatrocinco);
        assertTrue(g2.isConnected(uno));
	}
	
	@Test
	public void testStronglyConnectedComponents() {
		g1.addVertex(uno);
        g1.addVertex(dos);
        g1.addVertex(tres);
        g1.addVertex(cuatro);
        g1.addVertex(cinco);
        g1.addEdge(unodos);
        g1.addEdge(dostres);
        g1.addEdge(tresdos);
        g1.addEdge(unotres);
        g1.addEdge(unocuatro);
        g1.addEdge(cuatrocinco);
        g1.addEdge(cincouno);
        g1.addEdge(cincotres);
        
        ITable<Vertex<Integer>, Integer> components = g1.stronglyConnectedComponents(uno);
        IList<Vertex<Integer>> keys = components.keyList();
        ISet<Integer> set = new Set<>();
        for (Vertex<Integer> vertex : keys) {
			set.add(components.get(vertex));
		}
        assertEquals((Integer)2, set.cardinal());
	}
	
	@Test
	public void testTopologicalSort() {
		g1.addVertex(uno);
        g1.addVertex(dos);
        g1.addVertex(tres);
        g1.addVertex(cuatro);
        g1.addVertex(cinco);
        g1.addVertex(seis);
        g1.addVertex(siete);
        g1.addVertex(ocho);
        g1.addVertex(nueve);
        g1.addVertex(diez);
        g1.addVertex(once);
        g1.addVertex(doce);
        g1.addEdge(unodos);
        g1.addEdge(unotres);
        g1.addEdge(unocuatro);
        g1.addEdge(unocinco);
        g1.addEdge(unoseis);
        g1.addEdge(trescinco);
        g1.addEdge(cincoseis);
        g1.addEdge(cincosiete);
        g1.addEdge(seisocho);
        g1.addEdge(nuevetres);
        g1.addEdge(nuevediez);
        g1.addEdge(nueveonce);
        g1.addEdge(diezonce);
        g1.addEdge(diezdoce);
        g1.addEdge(oncedoce);
        
        IList<Vertex<Integer>> sort = g1.topologicalSort();
        assertEquals((Integer)12, sort.size());
        String result =
        		sort.toString().replaceFirst("org.jomaveger.structures.LinkedList", "");
        assertEquals("[(1,10), (9,90), (2,20), (4,40), (3,30), (10,100), (5,50), (11,110), (6,60), (7,70), (12,120), (8,80), ]", result);
	}
	
	@Test
	public void testPrim() {
		GraphAlgorithms<Integer> g2;
		g2 = new GraphAlgorithms<>(false, true);
		g2.addVertex(uno);
        g2.addVertex(dos);
        g2.addVertex(tres);
        g2.addVertex(cuatro);
        g2.addVertex(cinco);
        g2.addVertex(seis);
        g2.addVertex(siete);
        
        g2.addEdge(unodos1);
        g2.addEdge(unotres1);
        g2.addEdge(unocuatro3);
        g2.addEdge(dostres1);
        g2.addEdge(trescuatro2);
        g2.addEdge(trescinco4);
        g2.addEdge(cincoseis2);
        g2.addEdge(cincosiete2);
        g2.addEdge(seissiete1);
        
        CostPath<Integer> prim = g2.prim(uno);
        assertEquals((Double)11.0, prim.cost);
	}
}
