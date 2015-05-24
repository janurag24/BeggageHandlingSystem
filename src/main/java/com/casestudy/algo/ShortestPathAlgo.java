package com.casestudy.algo;

import java.util.concurrent.ConcurrentSkipListSet;

import com.casestudy.domain.graph.Vertex;

/**
 */
public interface ShortestPathAlgo {
	/**
	 * Method execute.
	 * @param vertexSet ConcurrentSkipListSet<Vertex>
	 */
	void execute(ConcurrentSkipListSet<Vertex> vertexSet);
}