package com.casestudy.domain.graph;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import org.apache.log4j.Logger;
import com.casestudy.algo.ShortestPathAlgo;
import com.casestudy.algo.dijkstraAlgoImpl;

/**
 */
public final class Graph {
	private final ConcurrentHashMap<String, Vertex> graph;
	final static Logger LOGGER = Logger.getLogger(Graph.class);
	private ShortestPathAlgo algo;
	
	/** Builds a graph from a set of edges * @param edges List<Edge>
	 */
	public Graph(List<Edge> edges) {
		LOGGER.info("Graph::Constructor Starts");
		int hashmapShardSize;
		if ( null != edges) {
			if(edges.size() < 17 ) 
				hashmapShardSize = 16; 
			else 
				hashmapShardSize = edges.size(); 
		} else {
			hashmapShardSize = 16; 
		}
		LOGGER.info("Graph::Constructor ConcurrentHashMap hashmapShardSize " + hashmapShardSize );

		graph = new ConcurrentHashMap<>(hashmapShardSize, 0.9f, 1);

		// one pass to find all vertices
		LOGGER.info("Graph::Constructor" + " pass to find all vertices" );
		for (Edge e : edges) {
			graph.putIfAbsent(e.getVertex1(), new Vertex(e.getVertex1()));
			graph.putIfAbsent(e.getVertex2(), new Vertex(e.getVertex2()));
		}

		// another pass to set neighboring vertices
		LOGGER.info("Graph::Constructor" + " another pass to set neighboring vertices" );
		for (Edge e : edges) {
			graph.get(e.getVertex1()).getNeighbours().put(graph.get(e.getVertex2()), e.getTravelTime()); 
			graph.get(e.getVertex2()).getNeighbours().put(graph.get(e.getVertex1()), e.getTravelTime()); 
		}
		LOGGER.info("Graph::Constructor Ends");
	}

	/**
	 * Method computeShortestPath.
	 * @param startName String
	 */
	public void computeShortestPath(String startName) {
		LOGGER.info("Graph::computeShortestPath Starts");

		if (!graph.containsKey(startName)) {
			LOGGER.error("Graph::computeShortestPath Graph doesn't contain start vertex "+	startName);
			return;
		}
		final Vertex source = graph.get(startName);
		ConcurrentSkipListSet<Vertex> vertextSet = new ConcurrentSkipListSet<>();

		// set-up vertices
		LOGGER.info("Graph::computeShortestPath set-up vertices");
		for (Vertex vertex : graph.values()) {
			synchronized (vertex) {
				vertex.setPrevious( vertex == source ? source : null);
				vertex.setDistance(vertex == source ? 0 : Integer.MAX_VALUE);
			}
			vertextSet.add(vertex);
		}

		algo = new dijkstraAlgoImpl();
		algo.execute(vertextSet);
		LOGGER.info("Graph::computeShortestPath Ends");
	}

	/** Prints a path from the source to the specified vertex * @param endName String
	 * @return String
	 */
	public String printPath(String endName) {
		LOGGER.info("Graph::printPath Starts");

		if (!graph.containsKey(endName)) {
			LOGGER.error("Graph doesn't contain end vertex " + endName);
			return null;
		}

		String value =graph.get(endName).printPath(true, "");
		LOGGER.info("Graph::printPath Ends");
		return value;
	}
}
