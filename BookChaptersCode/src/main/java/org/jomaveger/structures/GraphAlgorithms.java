package org.jomaveger.structures;

import java.util.PriorityQueue;
import java.util.Queue;

public class GraphAlgorithms<T> extends Graph<T> {
	
	public GraphAlgorithms() {
		super();
	}
	
	public GraphAlgorithms(boolean isDirected, boolean isWeighted) {
		super(isDirected, isWeighted);
	}
	
	public IList<Vertex<T>> DFS(Vertex<T> v, int k, ITable<Vertex<T>, Integer> path, IList<Vertex<T>> dfsList) {
		k++;
		path.set(v, k);
		dfsList.addLast(v);
		IList<Vertex<T>> adj = getAdjVertex(v);
		while (!adj.isEmpty()) {
			Vertex<T> w = adj.getFirst();
			adj.removeFirst();
			if (path.get(w) == 0) {
				dfsList = DFS(w, k, path, dfsList);
			}
		}
		return dfsList;
	}
	
	public IList<Vertex<T>> allDFS() {
		int k = 0;
		IList<Vertex<T>> dfsList = new LinkedList<>();
		ITable<Vertex<T>, Integer> path = new LinkedTable<>();
		for (Vertex<T> vertex : vertex) {
			path.set(vertex, 0);
		}
		for (Vertex<T> vertex : vertex) {
			if (path.get(vertex) == 0) {
				dfsList = DFS(vertex, k, path, dfsList);
			}
		}
		return dfsList;
	}
	
	public IList<Vertex<T>> itDFS(Vertex<T> v, ITable<Vertex<T>, Integer> path, IList<Vertex<T>> dfsList) {
		IStack<VertexInfo<T>> stack = new LinkedStack<>();
		VertexInfo<T> p = new VertexInfo<>();
		VertexInfo<T> q, r;
		int k = 1;
		path.set(v, k);
		dfsList.addLast(v);
		p.vertex = v;
		p.adj = getAdjVertex(v);
		stack.push(p);
		
		while (!stack.isEmpty()) {
			p = stack.peek();
			stack.pop();
			if (!p.adj.isEmpty()) {
				Vertex<T> w = p.adj.getFirst();
				p.adj.removeFirst();
				r = new VertexInfo<>();
				r.vertex = p.vertex;
				r.adj = p.adj;
				stack.push(r);
				if (path.get(w) == 0) {
					k++;
					path.set(w, k);
					dfsList.addLast(w);
					q = new VertexInfo<>();
					q.vertex = w;
					q.adj = getAdjVertex(w);
					stack.push(q);
				}
			}
		}
		
		return dfsList;
	}
	
	public IList<Vertex<T>> allItDFS() {
		IList<Vertex<T>> dfsList = new LinkedList<>();
		ITable<Vertex<T>, Integer> path = new LinkedTable<>();
		for (Vertex<T> vertex : vertex) {
			path.set(vertex, 0);
		}
		for (Vertex<T> vertex : vertex) {
			if (path.get(vertex) == 0) {
				dfsList = itDFS(vertex, path, dfsList);
			}
		}
		return dfsList;
	}
	
	public IList<Vertex<T>> BFS(Vertex<T> v, ITable<Vertex<T>, Integer> path, IList<Vertex<T>> bfsList) {
		IQueue<Vertex<T>> q = new LinkedQueue<>();
		Vertex<T> u, w;
		IList<Vertex<T>> l;
		int k = 1;
		path.set(v, k);
		bfsList.addLast(v);
		q.enqueue(v);
		
		while (!q.isEmpty()) {
			u = q.front();
			q.dequeue();
			l = getAdjVertex(u);
			while (!l.isEmpty()) {
				w = l.getFirst();
				l.removeFirst();
				if (path.get(w) == 0) {
					k++;
					path.set(w, k);
					bfsList.addLast(w);
					q.enqueue(w);
				}
			}
			
		}
		
		return bfsList;
	}
	
	public IList<Vertex<T>> allBFS() {
		IList<Vertex<T>> bfsList = new LinkedList<>();
		ITable<Vertex<T>, Integer> path = new LinkedTable<>();
		for (Vertex<T> vertex : vertex) {
			path.set(vertex, 0);
		}
		for (Vertex<T> vertex : vertex) {
			if (path.get(vertex) == 0) {
				bfsList = BFS(vertex, path, bfsList);
			}
		}
		return bfsList;
	}
	
	public boolean isConnected(Vertex<T> v) {
		int k = 0;
		IList<Vertex<T>> dfsList = new LinkedList<>();
		ITable<Vertex<T>, Integer> path = new LinkedTable<>();
		for (Vertex<T> vertex : vertex) {
			path.set(vertex, 0);
		}
		dfsList = DFS(v, k, path, dfsList);
		return (dfsList.size() == vertex.size());
	}
	
	public IList<Vertex<T>> getAdjVertex(Vertex<T> v) {
		IList<Vertex<T>> adj = new LinkedList<>();
		IList<Edge<T>> edges = this.getAdj(v);
		for (Edge<T> edge : edges) {
			adj.addLast(edge.getDest());
		}
		return adj;
	}
	
	public ITable<Vertex<T>, Integer> stronglyConnectedComponents(Vertex<T> v) {
		int k = 0; int[] c = {0};
		ITable<Vertex<T>, Integer> path = new LinkedTable<>();
		for (Vertex<T> vertex : vertex) {
			path.set(vertex, 0);
		}
		ITable<Vertex<T>, Integer> component = new LinkedTable<>();
		for (Vertex<T> vertex : vertex) {
			component.set(vertex, 0);
		}
		ITable<Vertex<T>, Integer> higher = new LinkedTable<>();
		for (Vertex<T> vertex : vertex) {
			higher.set(vertex, 0);
		}
		IStack<Vertex<T>> stack = new LinkedStack<>();
		for (Vertex<T> vertex : vertex) {
			if (path.get(vertex) == 0) {
				component = stronglyConnectedDFS(vertex, k, c, stack, path, component, higher);
			}
		}
		return component;
	}
	
	private ITable<Vertex<T>, Integer> stronglyConnectedDFS(Vertex<T> v, int k, int[] c, IStack<Vertex<T>> stack,
			ITable<Vertex<T>, Integer> path, ITable<Vertex<T>, Integer> component, ITable<Vertex<T>, Integer> higher) {
		k++;
		path.set(v, k);
		higher.set(v, k);
		stack.push(v);
		IList<Vertex<T>> list = getAdjVertex(v);
		while (!list.isEmpty()) {
			Vertex<T> w = list.getFirst();
			list.removeFirst();
			if (path.get(w) == 0) {
				stronglyConnectedDFS(w, k, c, stack, path, component, higher);
				higher.set(v, Math.min(higher.get(v), higher.get(w)));
			} else {
				if ((path.get(w) < path.get(v)) && component.get(w) == 0) {
					higher.set(v, Math.min(higher.get(v), path.get(w)));	
				}
			}
		}
		if (higher.get(v) == path.get(v)) {
			c[0]++;
			component.set(v, c[0]);
			Vertex<T> w = stack.peek();
			stack.pop();
			while (!w.equals(v)) {
				component.set(w, c[0]);
				w = stack.peek();
				stack.pop();
			}
		}
		return component;
	}
	
	public ITable<Vertex<T>, Integer> getInputDegree() {
		ITable<Vertex<T>, Integer> idegree = new LinkedTable<>();
		
		for (Vertex<T> v : vertex) {
			int input = 0;
			for (IList<Edge<T>> iList : edges) {
				for (Edge<T> edge : iList) {
					if (edge.getDest().equals(v)) {
						input++;
					}
				}
			}
			idegree.set(v, input);
		}
		
		return idegree;
	}
	
	public IList<Vertex<T>> topologicalSort() {
		IList<Vertex<T>> tsort = new LinkedList<>();
		IList<Vertex<T>> adj;
		ITable<Vertex<T>, Integer> idegree = getInputDegree();
		IQueue<Vertex<T>> q = new LinkedQueue<>();
		IList<Vertex<T>> idl = idegree.keyList();
		for (Vertex<T> vertex : idl) {
			if (idegree.get(vertex) == 0) {
				q.enqueue(vertex);
			}
		}
		int posicion = -1;
		while (!q.isEmpty()) {
			Vertex<T> v = q.front();
			q.dequeue();
			posicion++;
			tsort.add(posicion, v);
			adj = getAdjVertex(v);
			
			while (!adj.isEmpty()) {
				Vertex<T> w = adj.getFirst();
				adj.removeFirst();
				idegree.set(w, idegree.get(w) - 1);
				if (idegree.get(w) == 0) {
					q.enqueue(w);
				}
			}
		}
		return tsort;
	}
	
	public CostPath<T> prim(Vertex<T> v) {
		Queue<Edge<T>> pq = new PriorityQueue<>();
		
		IList<Edge<T>> mst = new LinkedList<>();
		ITable<Vertex<T>, Boolean> visitedVertex = new LinkedTable<>();
		for (Vertex<T> vertex : vertex) {
			visitedVertex.set(vertex, false);
		}
		
		int count = 0;
		Double wmst = 0.0;
		
		visitedVertex.set(v, true);
		for (Edge<T> edge : getAdj(v)) {
			pq.add(edge);
		}
		
		while (!pq.isEmpty()) {
			if (count == vertex.size() - 1) {
				break;
			}
			
			Edge<T> e = pq.remove();
			Vertex<T> u = e.getOrig();
			Vertex<T> w;
			if (visitedVertex.get(u) == true) {
				w = e.getDest();
			} else {
				w = u;
			}
			
			if (visitedVertex.get(w) == true) {
				continue;
			}
			
			visitedVertex.set(w, true);
			wmst += e.getWeight();
			mst.addLast(e);
			count++;
			
			for (Edge<T> e2 : getAdj(w)) {
				Vertex<T> s = e2.getDest();
				
				if (visitedVertex.get(s) == false) {
					pq.add(e2);	
				}
			}
		}
		
		CostPath<T> cp = new CostPath<>();
        cp.cost = wmst;
        cp.eList = mst;
        return cp;
	}

	public static class VertexInfo<T> {
		
		public Vertex<T> vertex;
		public IList<Vertex<T>> adj;
	}
	
	public static class CostPath<T> {
		
		public IList<Edge<T>> eList;
		public Double cost;
	}
}
