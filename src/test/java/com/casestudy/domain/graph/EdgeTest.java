package com.casestudy.domain.graph;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>EdgeTest</code> contains tests for the class <code>{@link Edge}</code>.
 *
 * @generatedBy CodePro at 15/5/15 10:33 PM
 * @author Anurag
 * @version $Revision: 1.0 $
 */
public class EdgeTest {

	Edge fixture;

	/**
	 * Run the Edge(String,String,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testEdge_1()
		throws Exception {
		String v1 = "A";
		String v2 = "B";
		int travelTime = 1;

		Edge result = new Edge(v1, v2, travelTime);

		assertNotNull(result);
		assertEquals("A", result.getVertex1());
		assertEquals(1, result.getTravelTime());
		assertEquals("B", result.getVertex2());
	}

	/**
	 * Run the int getTravelTime() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testGetTravelTime_1()
		throws Exception {

		int result = fixture.getTravelTime();

		assertEquals(1000, result);
	}

	/**
	 * Run the String getVertex1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testGetVertex1_1()
		throws Exception {

		String result = fixture.getVertex1();

		assertEquals("B", result);
	}

	/**
	 * Run the String getVertex2() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testGetVertex2_1()
		throws Exception {

		String result = fixture.getVertex2();

		assertEquals("C", result);
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
		fixture = new Edge("B", "C", 1000);
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
		new org.junit.runner.JUnitCore().run(EdgeTest.class);
	}
}