package org.jomaveger.structures;

import java.io.Serializable;
import java.util.Objects;

import org.jomaveger.lang.DeepCloneable;
import org.jomaveger.lang.dbc.Contract;

public class Graph<T> implements IGraph<T>, Serializable {
	
	private int size;
	private IList<Vertex<T>> vertex;
	private IList<IList<Edge<T>>> matrix;
	private boolean isDirected;
	private boolean isWeighted;
	
	public Graph(boolean isDirected, boolean isWeighted) {
		this.size = 0;
		this.vertex = new LinkedList<>();
		this.matrix = new LinkedList<>();
		this.isDirected = isDirected;
		this.isWeighted = isWeighted;
		
		Contract.ensure(isEmpty());
        Contract.invariant(checkInvariant());
	}

	@Override
	public boolean isDirected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWeighted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addVertex(Vertex<T> v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEdge(Edge<T> e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeVertex(Vertex<T> v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEdge(Edge<T> e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasVertex(Vertex<T> v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasEdge(Edge<T> e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getWeight(Edge<T> e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IList<Vertex<T>> getAdj(Vertex<T> v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int numVertex() {
		// TODO Auto-generated method stub
		return 0;
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
            deepCopy = new Graph<>(false, false);
        }
        Contract.ensure(deepCopy.equals(this) || deepCopy.isEmpty());
        Contract.invariant(checkInvariant());
        return deepCopy;
	}

	private boolean checkInvariant() {
		return this.size >= 0;
	}
	
	@Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(this.getClass().getName() + "[");

        for (IList<Edge<T>> iList : matrix) {
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

        if (!Objects.equals(this.size, that.size)) return false;
        
        if (!Objects.equals(this.vertex, that.vertex)) return false;
        
        for (int i = 0; i < this.matrix.size(); i++) {
        	if (!Objects.equals(this.matrix.get(i), that.matrix.get(i))) return false;
			
		}

        return true;
    }

    @Override
    public int hashCode() {
    	final int prime = 31;
		int result = 1;
		result = prime * result + Integer.valueOf(this.size).hashCode();
		result = prime * result + vertex.hashCode();
		result = prime * result + matrix.hashCode();
		return result;
    }
}
