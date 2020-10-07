package org.jomaveger.structures;

import java.io.Serializable;
import java.util.Objects;

import org.jomaveger.lang.dbc.Contract;

public class Edge<T> implements Comparable<Edge<T>>, Serializable {
	
	private Vertex<T> orig;
	private Vertex<T> dest;
	private double weight;
	
	public Edge(Vertex<T> v, Vertex<T> w, double weight) {
		Contract.require(v != null && w != null);
		this.orig = v;
		this.dest = w;
		this.weight = weight;
	}

	public Vertex<T> getOrig() {
		return orig;
	}

	public void setOrig(Vertex<T> orig) {
		this.orig = orig;
	}

	public Vertex<T> getDest() {
		return dest;
	}

	public void setDest(Vertex<T> dest) {
		this.dest = dest;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge<T> that) {
		return Double.compare(this.weight, that.weight);
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
        string.append("[");

        string.append(orig).append("---").append(dest);
        
        if (!Double.isNaN(weight))
        	string.append(String.format(",%f",weight));

        string.append("]");
        return string.toString();
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;

        if (otherObject == null
                || this.getClass() != otherObject.getClass())
            return false;

        Edge<T> that = (Edge<T>) otherObject;
        
        if (!Objects.equals(this.orig, that.orig))
            return false;
        
        if (!Objects.equals(this.dest, that.dest))
            return false;

        return Objects.equals(this.weight, that.weight);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orig.hashCode();
		result = prime * result + dest.hashCode();
		result = prime * result + Double.valueOf(weight).hashCode();
		return result;
	}
}
