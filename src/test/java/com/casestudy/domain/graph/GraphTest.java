package com.casestudy.domain.graph;

import java.util.LinkedList;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>GraphTest</code> contains tests for the class <code>{@link Graph}</code>.
 *
 * @generatedBy CodePro at 15/5/15 10:33 PM
 * @author Anurag
 * @version $Revision: 1.0 $
 */
public class GraphTest {
	List<Edge> edges = new LinkedList();
	/**
	 * Run the Graph(List<Edge>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testGraph_1()
		throws Exception {
//		List<Edge> edges = new LinkedList();

		Graph result = new Graph(edges);
		result.computeShortestPath("A");
		result.computeShortestPath("B");
		result.computeShortestPath("C");
		result.computeShortestPath("F");
		assertNotNull(result);
		assertEquals("F A B  : 23", result.printPath("B"));

	}

	/**
	 * Run the Graph(List<Edge>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testGraph_2()
		throws Exception {

		Graph result = new Graph(edges);
		result.computeShortestPath("A");
		result.computeShortestPath("B");
		result.computeShortestPath("C");
		result.computeShortestPath("F");
		assertNotNull(result);
		assertEquals("F C  : 5", result.printPath("C"));
	}

	/**
	 * Run the Graph(List<Edge>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testGraph_3()
		throws Exception {

		Graph result = new Graph(edges);
		result.computeShortestPath("A");
		result.computeShortestPath("B");
		result.computeShortestPath("F");

		assertNotNull(result);
		assertEquals("F ", result.printPath("F"));
	}

	/**
	 * Run the void computeShortestPath(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testComputeShortestPath_1()
		throws Exception {
		Graph fixture = new Graph(edges);

		String startName = "A";

		fixture.computeShortestPath(startName);

	}


	/**
	 * Run the String printPath(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testPrintPath_1()
		throws Exception {
		Graph fixture = new Graph(edges);
		String endName = "B";

		fixture.computeShortestPath("A");
		fixture.computeShortestPath("B");
		fixture.computeShortestPath("C");
		fixture.computeShortestPath("F");

		String result = fixture.printPath(endName);

		assertNotNull(result);
		assertEquals("F A B  : 23", result);

	}


	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Before
	public void setUp()
		throws Exception {

		Edge edge1 = new Edge("A","B",11);
		Edge edge2 = new Edge("B","C",100);
		Edge edge3 = new Edge("A","C",20);
		Edge edge4 = new Edge("A","F",12);
		Edge edge5 = new Edge("C","F",5);
		edges.add(edge1);
		edges.add(edge2);
		edges.add(edge3);
		edges.add(edge4);
		edges.add(edge5);
		
		
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(GraphTest.class);
	}
}