package com.casestudy.domain;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>BagTest</code> contains tests for the class <code>{@link Bag}</code>.
 *
 * @generatedBy CodePro at 15/5/15 10:33 PM
 * @author Anurag
 * @version $Revision: 1.0 $
 */
public class BagTest {

	Bag fixture;
	
	/**
	 * Run the Bag(String,String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	
	@Test
	public void testBag_1()
		throws Exception {

		String bagNo = "0002";
		String source = "A5";
		String flightId = "UA17";

		Bag result = new Bag(bagNo, source, flightId);

		assertNotNull(result);
		assertEquals("Bag :0002 A5 UA17", result.toString());
		assertEquals("A5", result.getEntryPoint());
		assertEquals("UA17", result.getFlightId());
		assertEquals("0002", result.getBagNo());
	}

	/**
	 * Run the String getBagNo() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testGetBagNo_1()
		throws Exception {

		String result = fixture.getBagNo();

		// add additional test code here
		assertEquals("0002", result);
	}

	/**
	 * Run the String getEntryPoint() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testGetEntryPoint_1()
		throws Exception {

		String result = fixture.getEntryPoint();

		// add additional test code here
		assertEquals("A5", result);
	}

	/**
	 * Run the String getFlightId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/5/15 10:33 PM
	 */
	@Test
	public void testGetFlightId_1()
		throws Exception {

		String result = fixture.getFlightId();

		assertEquals("UA17", result);
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

		assertEquals("Bag :0002 A5 UA17", result);
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
		String bagNo = "0002";
		String source = "A5";
		String flightId = "UA17";

		fixture = new Bag(bagNo, source, flightId);

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
		new org.junit.runner.JUnitCore().run(BagTest.class);
	}
}