package com.casestudy.domain.graph;

import java.util.Map;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>VertexTest</code> contains tests for the class <code>{@link Vertex}</code>.
 *
 * @generatedBy CodePro at 15/5/15 10:33 PM
 * @author Anurag
 * @version $Revision: 1.0 $
 */
public class VertexTest {
	/**
	 * Run the Vertex(String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testVertex_1()
		throws Exception {
		String name = "Concourse_A_Ticketing";

		Vertex result = new Vertex(name);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getPrevious());
		assertEquals(Integer.MAX_VALUE, result.getDistance());
	}

	/**
	 * Run the int compareTo(Vertex) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testCompareTo_1()
		throws Exception {
		Vertex fixture = new Vertex("");
		fixture.setPrevious(new Vertex(""));
		fixture.setDistance(1);
		Vertex other = new Vertex("");
		other.setDistance(1);

		int result = fixture.compareTo(other);

		assertEquals(0, result);
	}

	/**
	 * Run the int compareTo(Vertex) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testCompareTo_2()
		throws Exception {
		Vertex fixture = new Vertex("");
		fixture.setPrevious(new Vertex(""));
		fixture.setDistance(1);
		Vertex other = new Vertex("");
		other.setDistance(1);

		int result = fixture.compareTo(other);

		assertEquals(0, result);
	}

	/**
	 * Run the int getDistance() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testGetDistance_1()
		throws Exception {
		Vertex fixture = new Vertex("");
		fixture.setPrevious(new Vertex(""));
		fixture.setDistance(1);

		int result = fixture.getDistance();

		assertEquals(1, result);
	}

	/**
	 * Run the Map<Vertex, Integer> getNeighbours() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testGetNeighbours_1()
		throws Exception {
		Vertex fixture = new Vertex("");
		fixture.setPrevious(new Vertex(""));
		fixture.setDistance(1);

		Map<Vertex, Integer> result = fixture.getNeighbours();

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Vertex getPrevious() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testGetPrevious_1()
		throws Exception {
		Vertex fixture = new Vertex("");
		fixture.setPrevious(new Vertex(""));
		fixture.setDistance(1);

		Vertex result = fixture.getPrevious();

		assertNotNull(result);
		assertEquals(null, result.getPrevious());
		assertEquals(Integer.MAX_VALUE, result.getDistance());
	}

	/**
	 * Run the String printPath(boolean,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testPrintPath_1()
		throws Exception {
		Vertex fixture = new Vertex("");
		fixture.setPrevious(new Vertex(""));
		fixture.setDistance(1);
		boolean flag = true;
		String value = "";

		String result = fixture.printPath(flag, value);

		assertEquals("(unreached)  : 1", result);
	}

	/**
	 * Run the String printPath(boolean,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testPrintPath_2()
		throws Exception {
		Vertex fixture = new Vertex("");
		fixture.setPrevious(new Vertex(""));
		fixture.setDistance(1);
		boolean flag = false;
		String value = "";

		String result = fixture.printPath(flag, value);

		// add additional test code here
		assertEquals("(unreached) ", result);
	}

	/**
	 * Run the String printPath(boolean,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testPrintPath_3()
		throws Exception {
		Vertex fixture = new Vertex("");
		fixture.setPrevious((Vertex) null);
		fixture.setDistance(1);
		boolean flag = true;
		String value = "";

		String result = fixture.printPath(flag, value);

		assertEquals("(unreached)", result);
	}

	/**
	 * Run the String printPath(boolean,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testPrintPath_4()
		throws Exception {
		Vertex fixture = new Vertex("");
		fixture.setPrevious(new Vertex(""));
		fixture.setDistance(1);
		boolean flag = true;
		String value = "";

		String result = fixture.printPath(flag, value);

		assertEquals("(unreached)  : 1", result);
	}

	/**
	 * Run the String printPath(boolean,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testPrintPath_5()
		throws Exception {
		Vertex fixture = new Vertex("");
		fixture.setPrevious(new Vertex(""));
		fixture.setDistance(1);
		boolean flag = true;
		String value = null;

		String result = fixture.printPath(flag, value);

		assertEquals("", result);
	}

	/**
	 * Run the void setDistance(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testSetDistance_1()
		throws Exception {
		Vertex fixture = new Vertex("");
		fixture.setPrevious(new Vertex(""));
		fixture.setDistance(1);
		int dist = 1;

		fixture.setDistance(dist);

	}

	/**
	 * Run the void setPrevious(Vertex) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testSetPrevious_1()
		throws Exception {
		Vertex fixture = new Vertex("");
		fixture.setPrevious(new Vertex(""));
		fixture.setDistance(1);
		Vertex previous = new Vertex("");

		fixture.setPrevious(previous);

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
		// add additional set up code here
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
		new org.junit.runner.JUnitCore().run(VertexTest.class);
	}
}