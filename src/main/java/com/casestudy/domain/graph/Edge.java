package com.casestudy.domain.graph;

/**
 */
public final class Edge {
	private final String vertex1, vertex2;
	private final int travelTime;

	/**
	 * Constructor for Edge.
	 * @param v1 String
	 * @param v2 String
	 * @param travelTime int
	 */
	public Edge(String v1, String v2, int travelTime) {
		this.vertex1 = v1;
		this.vertex2 = v2;
		this.travelTime = travelTime;
	}

	/**
	 * Method getVertex1.
	 * @return String
	 */
	public String getVertex1() {
		return vertex1;
	}

	/**
	 * Method getVertex2.
	 * @return String
	 */
	public String getVertex2() {
		return vertex2;
	}

	/**
	 * Method getTravelTime.
	 * @return int
	 */
	public int getTravelTime() {
		return travelTime;
	}
	
	
}
