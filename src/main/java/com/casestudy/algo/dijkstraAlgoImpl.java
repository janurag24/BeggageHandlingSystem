package com.casestudy.algo;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListSet;

import org.apache.log4j.Logger;
import com.casestudy.domain.graph.Vertex;

/**
 */
public class dijkstraAlgoImpl implements ShortestPathAlgo {
	final static Logger LOGGER = Logger.getLogger(dijkstraAlgoImpl.class);

	/**
	 * Method execute.
	 * @param vertexSet ConcurrentSkipListSet<Vertex>
	 * @see com.casestudy.algo.ShortestPathAlgo#execute(ConcurrentSkipListSet<Vertex>)
	 */
	@Override
	public void execute(final ConcurrentSkipListSet<Vertex> vertexSet) {
		LOGGER.info("dijkstraAlgoImpl::execute Starts");

		Vertex vertex1, vertex2;

		while (!vertexSet.isEmpty()) {
			vertex1 = vertexSet.pollFirst(); // vertex with shortest distance
												// (first iteration will return
												// source)
			if (vertex1.getDistance() == Integer.MAX_VALUE)
				break; // we can ignore u (and any other remaining vertices)
						// since they are unreachable

			// look at distances to each neighbour
			for (Map.Entry<Vertex, Integer> entry : vertex1.getNeighbours().entrySet()) {
				vertex2 = entry.getKey(); // the neighbour in this iteration

				final int alternateDistance = vertex1.getDistance() + entry.getValue();
				if (alternateDistance < vertex2.getDistance()) { 
					// shorter path to neighbour found
					vertexSet.remove(vertex2);
					vertex2.setDistance(alternateDistance);
					vertex2.setPrevious(vertex1);
					vertexSet.add(vertex2);
				}
			}
		}
		LOGGER.info("dijkstraAlgoImpl::execute Ends");
	}
}
