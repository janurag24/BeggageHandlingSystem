package com.casestudy.domain;

import org.junit.*;

import static com.casestudy.util.Constants.SPACE;
import static org.junit.Assert.*;

/**
 * The class <code>DepartureTest</code> contains tests for the class <code>{@link Departure}</code>.
 *
 * @generatedBy CodePro at 15/5/15 10:33 PM
 * @author Anurag
 * @version $Revision: 1.0 $
 */
public class DepartureTest {
	Departure fixture;

	/**
	 * Run the Departure(String,String,String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testDeparture_1()
		throws Exception {
		
		String flightno = "UA10";
		String gate = "A1";
		String dest = "MIA";
		String time = "08:00";

		Departure result = new Departure(flightno, gate, dest, time);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Departure: UA10 A1 MIA 08:00", result.toString());
		assertEquals("MIA", result.getDestination_code());
		assertEquals("UA10", result.getFlightNumber());
		assertEquals("A1", result.getFlightGate());
		assertEquals("08:00", result.getFlightTime());
	}

	/**
	 * Run the String getDestination_code() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testGetDestination_code_1()
		throws Exception {

		String result = fixture.getDestination_code();

		// add additional test code here
		assertEquals("JFK", result);
	}

	/**
	 * Run the String getFlightGate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testGetFlightGate_1()
		throws Exception {
		String result = fixture.getFlightGate();

		// add additional test code here
		assertEquals("A2", result);
	}

	/**
	 * Run the String getFlightNumber() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testGetFlightNumber_1()
		throws Exception {

		String result = fixture.getFlightNumber();

		// add additional test code here
		assertEquals("UA14", result);
	}

	/**
	 * Run the String getFlightTime() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testGetFlightTime_1()
		throws Exception {

		String result = fixture.getFlightTime();

		// add additional test code here
		assertEquals("09:45", result);
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {

		String result = fixture.toString();

		assertEquals("Departure: UA14 A2 JFK 09:45", result);
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
		fixture = new Departure("UA14", "A2", "JFK", "09:45");

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
		new org.junit.runner.JUnitCore().run(DepartureTest.class);
	}
}