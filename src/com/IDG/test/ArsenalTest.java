package com.IDG.test;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.DebugGraphics;

import org.junit.*;

import com.IDG.mapSimulator.Arsenal;

import static org.junit.Assert.*;

/**
 * The class <code>ArsenalTest</code> contains tests for the class <code>{@link Arsenal}</code>.
 *
 *
 * @author Raman
 * @version $Revision: 1.0 $
 */
public class ArsenalTest {
	/**
	 * Run the Arsenal() constructor test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testArsenal_1()
		throws Exception {

		Arsenal result = new Arsenal();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Arsenal() constructor test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testArsenal_2()
		throws Exception {

		Arsenal result = new Arsenal();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Arsenal() constructor test.
	 *
	 * @throws Exception
	 *
	 *
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
	 *
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
	 *
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ArsenalTest.class);
	}
}