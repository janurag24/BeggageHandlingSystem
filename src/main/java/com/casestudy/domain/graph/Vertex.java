package com.casestudy.domain.graph;

import java.util.HashMap;
import java.util.Map;

import static com.casestudy.util.Constants.*;

/**
 */
public final class Vertex implements Comparable<Vertex> {
	private final String name;
	private int distance = Integer.MAX_VALUE;
	private Vertex previous = null;
	private final Map<Vertex, Integer> neighbours = new HashMap<>();

	/**
	 * Constructor for Vertex.
	 * @param name String
	 */
	public Vertex(String name) {
		this.name = name;
	}
	
	/**
	 * Method getPrevious.
	 * @return Vertex
	 */
	public Vertex getPrevious() {
		return previous;
	}

	/**
	 * Method setPrevious.
	 * @param previous Vertex
	 */
	public synchronized  void  setPrevious(Vertex previous) {
		this.previous = previous;
	}

	/**
	 * Method getDistance.
	 * @return int
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * Method setDistance.
	 * @param dist int
	 */
	public synchronized void setDistance(int dist) {
		this.distance = dist;
	}

	
	/**
	 * Method getNeighbours.
	 * @return Map<Vertex,Integer>
	 */
	public Map<Vertex, Integer> getNeighbours() {
		return neighbours;
	}

	/**
	 * Method printPath.
	 * @param flag boolean
	 * @param value String
	 * @return String
	 */
	public String printPath(boolean flag, String value) {
		if(value == null) {
			value="";
		} else if (this == this.previous) {
			value = value  + this.name + SPACE;
		} else if (this.previous == null) {
			value = value + this.name + "(unreached)";
		} else {
			value = value + this.previous.printPath(false, value);
			value = value + this.name + SPACE;
			if (flag) {
				value = value + SPACE + ":" + SPACE + this.distance;
			}
		}
		return value;
	}

	/**
	 * Method compareTo.
	 * @param other Vertex
	 * @return int
	 */
	public int compareTo(Vertex other) {
		if (distance == other.distance)
			return name.compareTo(other.name);
		return Integer.compare(distance, other.distance);
	}
}
