package org.jomaveger.structures;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;

import org.jomaveger.lang.DeepCloneable;
import org.jomaveger.lang.dbc.Contract;

public class Graph<T> implements IGraph<T>, Serializable {
	
	private IList<Vertex<T>> vertex;
	private IList<IList<Edge<T>>> edges;
	private boolean isDirected;
	private boolean isWeighted;
	
	public Graph() {
		this(false, false);
	}
	
	public Graph(boolean isDirected, boolean isWeighted) {
		this.vertex = new LinkedList<>();
		this.edges = new LinkedList<>();
		this.isDirected = isDirected;
		this.isWeighted = isWeighted;
		
		Contract.ensure(isEmpty());
        Contract.invariant(checkInvariant());
	}
	
	private int search(Vertex<T> v) {
		return vertex.indexOf(v);
	}

	@Override
	public boolean isDirected() {
		return this.isDirected;
	}

	@Override
	public boolean isWeighted() {
		return this.isWeighted;
	}

	@Override
	public void addVertex(Vertex<T> v) {
		Contract.require(v != null);
		int index = this.search(v);
		if (index == -1) {
			vertex.addLast(v);
			edges.addLast(new LinkedList<>());
		}
	}

	@Override
	public void addEdge(Edge<T> e) {
		Contract.require(e != null);
		int vIndex = this.search(e.getOrig());
		int wIndex = this.search(e.getDest());
		if (vIndex != -1 && wIndex != -1) {
			IList<Edge<T>> eg = edges.get(vIndex);
			int eIndex = eg.indexOf(e);
			if (eIndex == -1) {
				eg.addLast(e);
				if (!isDirected()) {
					edges.get(wIndex).addLast(new Edge<>(e.getDest(), e.getOrig(), e.getWeight()));
				}
			} else {
				if (isWeighted()) {
					eg.get(eIndex).setWeight(e.getWeight());
				}
			}
		}
	}

	@Override
	public void removeVertex(Vertex<T> v) {
		Contract.require(v != null);
		int vIndex = this.search(v);
		if (vIndex != -1) {
			vertex.remove(vIndex);
			edges.remove(vIndex);
			for (IList<Edge<T>> iList : edges) {
				for (Iterator<Edge<T>> iterator = iList.iterator(); iterator.hasNext();) {
					Edge<T> elem = iterator.next();
					if (elem.getDest().equals(v)) {
						iterator.remove();
					}
				}
			}
		}
	}

	@Override
	public void removeEdge(Edge<T> e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasVertex(Vertex<T> v) {
		Contract.require(v != null);
		return (this.search(v) != -1);
	}

	@Override
	public boolean hasEdge(Edge<T> e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Double getWeight(Edge<T> e) {
		Contract.require(e != null && isWeighted());
		int vIndex = this.search(e.getOrig());
		int wIndex = this.search(e.getDest());
		if (vIndex != -1 && wIndex != -1) {
			IList<Edge<T>> eg = edges.get(vIndex);
			int eIndex = eg.indexOf(e);
			if (eIndex != -1) {
				return eg.get(eIndex).getWeight();
			}
		}
		return Double.NaN;
	}

	@Override
	public IList<Edge<T>> getAdj(Vertex<T> v) {
		Contract.require(v != null && hasVertex(v));
		int vIndex = this.search(v);
		return edges.get(vIndex);
	}

	@Override
	public boolean isEmpty() {
		return this.vertex.size() == 0;
	}

	@Override
	public int numVertex() {
		return vertex.size();
	}

	@Override
	public int numEdges() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IGraph<T> deepCopy() {
		Contract.invariant(checkInvariant());
		IGraph<T> deepCopy;
        try {
            deepCopy = DeepCloneable.deepCopy(this);
        } catch (Exception e) {
            deepCopy = new Graph<>();
        }
        Contract.ensure(deepCopy.equals(this) || deepCopy.isEmpty());
        Contract.invariant(checkInvariant());
        return deepCopy;
	}

	private boolean checkInvariant() {
		return this.vertex.size() >= 0;
	}
	
	@Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(this.getClass().getName() + "[");

        for (IList<Edge<T>> iList : edges) {
			string.append(iList);
		}

        string.append("]");
        return string.toString();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;

        if (otherObject == null || this.getClass() != otherObject.getClass())
            return false;

        Graph<T> that = (Graph<T>) otherObject;
        
        if (!Objects.equals(this.vertex, that.vertex)) return false;
        
        for (int i = 0; i < this.edges.size(); i++) {
        	if (!Objects.equals(this.edges.get(i), that.edges.get(i))) return false;
			
		}

        return true;
    }

    @Override
    public int hashCode() {
    	final int prime = 31;
		int result = 1;
		result = prime * result + vertex.hashCode();
		result = prime * result + edges.hashCode();
		return result;
    }
}
